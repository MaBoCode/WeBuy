package com.example.webuy.fragments;

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

import com.example.webuy.R;
import com.example.webuy.activities.PromotionDetailsActivity;
import com.example.webuy.adapters.PromotionRecyclerViewAdapter;
import com.example.webuy.interfaces.IFragment;
import com.example.webuy.models.PromotionModel;
import com.example.webuy.utils.DebugHelper;
import com.example.webuy.utils.PromotionMarginDecoration;

import java.util.ArrayList;
import java.util.Arrays;

public class RecommendationsFragment extends Fragment implements PromotionRecyclerViewAdapter.OnItemClickListener, IFragment {

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

    @Override
    public void setAttributes(View view) {
        recyclerView = view.findViewById(R.id.promotion_recycler_view);
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

        Bundle bundle = getCardBundle(position);
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
