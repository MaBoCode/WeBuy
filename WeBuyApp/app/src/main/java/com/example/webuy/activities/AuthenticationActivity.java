package com.example.webuy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.webuy.R;
import com.example.webuy.adapters.AuthPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class AuthenticationActivity extends AppCompatActivity {
    private ViewPager authViewPager;
    private TabLayout authTab;
    private FragmentPagerAdapter authPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        init();
        link();

    }

    private void init() {
        authViewPager = findViewById(R.id.authViewPager);
        authTab = findViewById(R.id.authTabLayout);

        authPagerAdapter = new AuthPagerAdapter(getSupportFragmentManager(), AuthenticationActivity.this);
    }

    private void link() {
        authViewPager.setAdapter(authPagerAdapter);
        authTab.setupWithViewPager(authViewPager);
    }
}
