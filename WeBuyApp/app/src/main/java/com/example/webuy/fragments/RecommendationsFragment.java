package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webuy.R;
import com.example.webuy.adapters.PromotionRecyclerViewAdapter;
import com.example.webuy.models.PromotionModel;
import com.example.webuy.utils.DebugHelper;
import com.example.webuy.utils.PromotionMarginDecoration;

import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationsFragment extends Fragment implements PromotionRecyclerViewAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private PromotionRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static RecommendationsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RecommendationsFragment fragment = new RecommendationsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recommendations_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);

        link();
    }

    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.promotion_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new PromotionRecyclerViewAdapter(getContext(), getDataModel(), this);
    }

    public void link() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new PromotionMarginDecoration(32));
    }

    public PromotionModel getDataModel() {
        return new PromotionModel(10);
    }

    @Override
    public void onPromotionCardClick(int position) {

        Bundle bundle = new Bundle();

        View item = recyclerView.findViewHolderForAdapterPosition(position).itemView;

        TextView titleView = item.findViewById(R.id.title_view);
        TextView descriptionView = item.findViewById(R.id.description_view);
        TextView oldPriceView = item.findViewById(R.id.old_price_view);
        TextView newPriceView = item.findViewById(R.id.new_price_view);

        ArrayList<String> card_data = new ArrayList<>(Arrays.asList(
                titleView.getText().toString(),
                descriptionView.getText().toString(),
                oldPriceView.getText().toString(),
                newPriceView.getText().toString()
        ));

        bundle.putStringArrayList("card_data", card_data);

        PromotionDetailsFragment fragment = PromotionDetailsFragment.newInstance();
        fragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
