package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.google.android.material.tabs.TabLayout;

public class PromotionsFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private FragmentPagerAdapter promotionsPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.promotions_fragment, container, false);
    }

    public void changeTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.promotions_title));
    }
}
