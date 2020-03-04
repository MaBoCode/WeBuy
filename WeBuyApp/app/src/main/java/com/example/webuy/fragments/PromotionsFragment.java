package com.example.webuy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.webuy.R;
import com.example.webuy.activities.DrawerActivity;
import com.example.webuy.adapters.PromotionsPagerAdapter;
import com.example.webuy.utils.DebugHelper;
import com.google.android.material.tabs.TabLayout;

public class PromotionsFragment extends Fragment {
    private TabLayout promotionsTab;
    private FragmentPagerAdapter promotionsPagerAdapter;
    private ViewPager promotionsViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        changeTitle();

         return inflater.inflate(R.layout.promotions_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAttributes(view);
        link();

    }

    public void changeTitle() {
        ((DrawerActivity)getActivity()).setToolbarTitle(getString(R.string.promotions_title));
    }

    public void setAttributes(View view) {
        promotionsViewPager = view.findViewById(R.id.promotions_view_pager);
        promotionsTab = view.findViewById(R.id.promotions_tab);
        promotionsPagerAdapter = new PromotionsPagerAdapter(getActivity().getSupportFragmentManager(), getContext());
    }

    public void link() {
        promotionsViewPager.setAdapter(promotionsPagerAdapter);
        promotionsTab.setupWithViewPager(promotionsViewPager);
    }
}
