package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.adapters.StoreRecyclerViewAdapter;
import com.example.webuy.models.StoreModel;
import com.example.webuy.utils.StoreMarginDecoration;

public class StoresFragment extends Fragment {

    private RecyclerView recyclerView;
    private StoreRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        changeTitle();

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

    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.store_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        adapter = new StoreRecyclerViewAdapter(getDataModel());
    }

    public void link() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new StoreMarginDecoration(32, 48));
    }

    public StoreModel getDataModel() {
        return new StoreModel(20);
    }

    public void changeTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.shops_title));
    }
}
