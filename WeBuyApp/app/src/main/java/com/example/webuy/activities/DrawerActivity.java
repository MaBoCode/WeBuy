package com.example.webuy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.webuy.R;
import com.example.webuy.fragments.ProfileFragment;
import com.example.webuy.fragments.PromotionsFragment;
import com.example.webuy.fragments.SettingsFragment;
import com.example.webuy.fragments.ShoppingCartFragment;
import com.example.webuy.fragments.StoresFragment;
import com.example.webuy.utils.DebugHelper;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout navDrawer;
    ActionBarDrawerToggle toggle;
    private NavigationView navView;
    Toolbar toolbar;
    private int fragmentContainerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        initAttributes();

        link();

        toggle.syncState();

        loadDefaultFragment(savedInstanceState);
    }

    public void link() {

        navView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);

        navDrawer.addDrawerListener(toggle);
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
                loadFragment(new PromotionsFragment());
                break;
            case R.id.shops_nav_item:
                loadFragment(new StoresFragment());
                break;
            case R.id.cart_nav_item:
                loadFragment(new ShoppingCartFragment());
                break;
            case R.id.profile_nav_item:
                loadFragment(new ProfileFragment());
                break;
            case R.id.settings_nav_item:
                loadFragment(new SettingsFragment());
                break;
        }

        navDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadDefaultFragment(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            navView.setCheckedItem(R.id.promotions_nav_item);
            setToolbarTitle(getString(R.string.promotions_title));
            loadFragment(new PromotionsFragment());
        }
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(fragmentContainerId, fragment).commit();
    }

    public void initAttributes() {
        navView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        navDrawer = findViewById(R.id.nav_drawer);

        fragmentContainerId = R.id.fragment_container;

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.promotions_title));
    }

    public void setToolbarTitle(String title) {

        toolbar.setTitle(title);
    }
}
