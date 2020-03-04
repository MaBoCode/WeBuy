package com.example.webuy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.webuy.R;
import com.example.webuy.fragments.PromotionsFragment;
import com.example.webuy.fragments.StoresFragment;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout navDrawer;
    ActionBarDrawerToggle toggle;
    private NavigationView navView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        setViews();

        init();

        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(navDrawer.isDrawerOpen(GravityCompat.START)) {
            navDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.promotions_nav_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PromotionsFragment()).commit();
                break;
            case R.id.shops_nav_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoresFragment()).commit();
                break;
            case R.id.cart_nav_item:
                Toast.makeText(getBaseContext(), R.string.shopping_cart_title, Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_nav_item:
                Toast.makeText(getBaseContext(), R.string.profile_title, Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings_nav_item:
                Toast.makeText(getBaseContext(), R.string.settings_title, Toast.LENGTH_SHORT).show();
                break;
        }

        navDrawer.closeDrawer(GravityCompat.START);
        return false;
    }

    public void setViews() {
        navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        navDrawer = findViewById(R.id.nav_drawer);
    }

    public void init() {

        navView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);

        navDrawer.addDrawerListener(toggle);
    }

    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }
}
