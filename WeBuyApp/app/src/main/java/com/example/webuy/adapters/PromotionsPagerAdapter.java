package com.example.webuy.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.webuy.R;

public class PromotionsPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    private Context context;

    public PromotionsPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.recommended_promotions_title);
            case 1:
                return context.getString(R.string.newest_promotions_title);
            case 2:
                return context.getString(R.string.most_bought_promotions_title);
        }

        return null;
    }
}
