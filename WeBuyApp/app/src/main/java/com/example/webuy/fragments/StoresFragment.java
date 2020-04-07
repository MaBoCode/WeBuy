package com.example.webuy.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.adapters.StoreRecyclerViewAdapter;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.models.Store;
import com.example.webuy.utils.DebugHelper;
import com.example.webuy.utils.StoreMarginDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StoresFragment extends Fragment implements IFragment {
    private final String API_URL = "https://webuy.sciences.univ-tours.fr/api/v1/magasins";

    private ArrayList<Store> stores = new ArrayList<>();
    private Comparator<Store> compareByName = new Comparator<Store>() {
        @Override
        public int compare(Store s1, Store s2) {
            return s1.getName().compareTo(s2.getName());
        }
    };
    private boolean sortedInAscendingOrder = false;
    private RecyclerView recyclerView;
    private StoreRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Response.Listener<JSONArray> responseListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            for(int i = 0; i < response.length(); i++) {
                try {
                    JSONObject entry = response.getJSONObject(i);
                    int storeID = entry.getInt("id_magasin");
                    String storeName = entry.getString("nom");
                    String storeAddress = entry.getString("adresse");
                    String logo = entry.getString("logo");
                    double latitude = entry.getDouble("latitude");
                    double longitude = entry.getDouble("longitude");

                    Store store = new Store(storeID, storeName, storeAddress, logo, latitude, longitude);
                    stores.add(store);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            adapter.notifyDataSetChanged();
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            DebugHelper.console(error.toString());
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTitle();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, API_URL, null, responseListener, errorListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(jsonArrayRequest);
        DebugHelper.console(String.valueOf(stores.size()));

        return inflater.inflate(R.layout.stores_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        link();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_action, menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_sort:
                if(sortedInAscendingOrder) {
                    Collections.sort(stores, compareByName.reversed());
                    sortedInAscendingOrder = false;
                } else {
                    Collections.sort(stores, compareByName);
                    sortedInAscendingOrder = true;
                }

                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.store_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        adapter = new StoreRecyclerViewAdapter(stores);
    }

    @Override
    public void setStyles() {

    }

    @Override
    public void link() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new StoreMarginDecoration(32, 48));
    }

    public void setTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.shops_title));
    }
}
