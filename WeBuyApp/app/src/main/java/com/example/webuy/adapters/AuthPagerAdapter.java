package com.example.webuy.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.webuy.R;
import com.example.webuy.fragments.auth.LoginFragment;
import com.example.webuy.fragments.auth.SignupFragment;

public class AuthPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 2;
    private Context context;

    public AuthPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SignupFragment.newInstance();
            case 1:
                return LoginFragment.newInstance();
        }

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
                return context.getString(R.string.signup_action);
            case 1:
                return context.getString(R.string.login_action);
        }

        return null;
    }
}
