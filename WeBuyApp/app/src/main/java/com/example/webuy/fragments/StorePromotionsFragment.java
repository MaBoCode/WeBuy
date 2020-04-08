package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.adapters.PromotionRecyclerViewAdapter;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.models.Store;

public class StorePromotionsFragment extends Fragment implements IFragment {

    private Store store;
    private RecyclerView recyclerView;
    private PromotionRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static StorePromotionsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        StorePromotionsFragment fragment = new StorePromotionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTitle();

        return inflater.inflate(R.layout.recommendations_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAttributes(view);

    }

    public void setTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(store.getName());
    }

    @Override
    public void setAttributes(View view) {
        store = (Store) getArguments().get("store_object");
        recyclerView = view.findViewById(R.id.promotion_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());

    }

    @Override
    public void setStyles() {

    }

    @Override
    public void link() {

    }
}
