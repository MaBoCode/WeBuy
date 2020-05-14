package com.example.webuy.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.webuy.R;
import com.example.webuy.activities.PromotionDetailsActivity;
import com.example.webuy.adapters.PromotionRecyclerViewAdapter;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.models.Product;
import com.example.webuy.models.Promotion;
import com.example.webuy.models.PromotionModel;
import com.example.webuy.models.Store;
import com.example.webuy.network.NetworkSingleton;
import com.example.webuy.utils.DebugHelper;
import com.example.webuy.utils.PromotionMarginDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationsFragment extends Fragment implements PromotionRecyclerViewAdapter.OnItemClickListener, IFragment {
    private final String API_URL = "https://webuy.sciences.univ-tours.fr/api/v1/achat-groupes?expand=%s&id_magasin=%d";

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Promotion> promotions = new ArrayList<>();

    private RecyclerView recyclerView;
    private PromotionRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Response.Listener<JSONArray> productsResponseListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            for(int i = 0; i < response.length(); i++) {
                try {
                    JSONObject entry = response.getJSONObject(i);
                    JSONObject JSONProduct = entry.getJSONObject("produit");

                    int productID = JSONProduct.getInt("id_produit");
                    String productLabel = JSONProduct.getString("libelle");
                    String productDescription = JSONProduct.getString("description");
                    String productImage = JSONProduct.getString("image");


                    Product product = new Product(productID, productLabel, productDescription, productImage);
                    products.add(product);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private Response.Listener<JSONArray> promoResponseListener = new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            for(int i = 0; i < response.length(); i++) {
                try {
                    JSONObject entry = response.getJSONObject(i);
                    JSONObject JSONProduct = entry.getJSONObject("produit");
                    JSONObject JSONPromo = entry.getJSONObject("promotion");

                    int productID = JSONProduct.getInt("id_produit");
                    String productLabel = JSONProduct.getString("libelle");
                    String productDescription = JSONProduct.getString("description");
                    String productImage = JSONProduct.getString("image");

                    int promoID = JSONPromo.getInt("id_promotion");
                    String promoOldPrice = JSONPromo.getString("prix_hors_promo");
                    String promoNewPrice = JSONPromo.getString("prix_promo");
                    int promoQuantity = JSONPromo.getInt("quantite_min");
                    Product product = new Product(productID, productLabel, productDescription, productImage);


                    Promotion promotion = new Promotion(promoID, promoOldPrice, promoNewPrice, promoQuantity, product);
                    products.add(product);
                    promotions.add(promotion);
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

    public static RecommendationsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecommendationsFragment fragment = new RecommendationsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //loadProductsAndPromotions();

        return inflater.inflate(R.layout.recommendations_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        link();
    }

    public void loadProductsAndPromotions() {
        @SuppressLint("DefaultLocale") String url = String.format(API_URL, "promotion,produit", 1);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, promoResponseListener, errorListener);
        //RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        NetworkSingleton.getInstance(getContext()).addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.promotion_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new PromotionRecyclerViewAdapter(getContext(), promotions, this);
    }

    @Override
    public void setStyles() {

    }

    @Override
    public void link() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new PromotionMarginDecoration(32));
    }

    public PromotionModel getDataModel() {
        return new PromotionModel(10);
    }

    @Override
    public void onPromotionCardClick(View itemView, int position) {
        Promotion promotion = promotions.get(position);

        Bundle bundle = new Bundle();
        bundle.putSerializable("promotion_object", promotion);
        bundle.putSerializable("product_object", promotion.getProduct());
        Intent intent = new Intent(getContext(), PromotionDetailsActivity.class);
        ActivityOptionsCompat activityOptions = getActivityOptions(itemView);

        intent.putExtras(bundle);


        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    public Bundle getCardBundle(int position) {
        Bundle bundle = new Bundle();

        View item = recyclerView.findViewHolderForAdapterPosition(position).itemView;

        TextView titleView = item.findViewById(R.id.title_view);
        TextView descriptionView = item.findViewById(R.id.description_view);
        TextView oldPriceView = item.findViewById(R.id.old_price_view);
        TextView newPriceView = item.findViewById(R.id.new_price_view);

        bundle.putString("card_title", titleView.getText().toString());
        bundle.putString("card_description", descriptionView.getText().toString());
        bundle.putString("card_old_price", oldPriceView.getText().toString());
        bundle.putString("card_new_price", newPriceView.getText().toString());

        return bundle;
    }

    public ActivityOptionsCompat getActivityOptions(View itemView) {

        Pair<View, String> title = new Pair<>(itemView.findViewById(R.id.title_view), getString(R.string.title_transition));
        Pair<View, String> image = new Pair<>(itemView.findViewById(R.id.product_image), getString(R.string.image_transition));


        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), title, image);

        return activityOptions;
    }
}
