package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.adapters.PromotionRecyclerViewAdapter;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.models.PromotionModel;
import com.example.webuy.utils.DebugHelper;
import com.example.webuy.utils.PromotionMarginDecoration;

public class NewestPromotionsFragment extends Fragment implements PromotionRecyclerViewAdapter.OnItemClickListener, IFragment {

    private RecyclerView recyclerView;
    private PromotionRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static NewestPromotionsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewestPromotionsFragment fragment = new NewestPromotionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newest_promotions_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        link();
    }

    @Override
    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.newest_promotions_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new PromotionRecyclerViewAdapter(getContext(), getDataModel(), this);
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
        DebugHelper.toast(getContext(), String.valueOf(position));
    }
}
