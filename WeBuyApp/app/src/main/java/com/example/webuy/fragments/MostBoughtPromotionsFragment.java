package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;

public class MostBoughtPromotionsFragment extends Fragment {

    public static MostBoughtPromotionsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MostBoughtPromotionsFragment fragment = new MostBoughtPromotionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.most_bought_promotions_fragment, container, false);
    }
}
