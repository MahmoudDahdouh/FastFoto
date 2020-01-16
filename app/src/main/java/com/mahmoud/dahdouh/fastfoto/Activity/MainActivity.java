package com.mahmoud.dahdouh.fastfoto.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mahmoud.dahdouh.fastfoto.Fragment.CategoryFragment;
import com.mahmoud.dahdouh.fastfoto.Fragment.FavoriteFragment;
import com.mahmoud.dahdouh.fastfoto.Fragment.HomeFragment;
import com.mahmoud.dahdouh.fastfoto.Fragment.SearchFragment;
import com.mahmoud.dahdouh.fastfoto.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set home fragment
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();

        // inflate


        // bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {

                    case R.id.main_btm_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.main_btm_category:
                        selectedFragment = new CategoryFragment();
                        break;
                    case R.id.main_btm_favorite:
                        selectedFragment = new FavoriteFragment();
                        break;
                    case R.id.main_btm_search:
                        selectedFragment = new SearchFragment();
                        break;
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.container, selectedFragment)
                        .commit();
                return true;
            }
        });
    }
}
