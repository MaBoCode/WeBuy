package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.webuy.R;

public class NewestPromotionsFragment extends Fragment {

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
}