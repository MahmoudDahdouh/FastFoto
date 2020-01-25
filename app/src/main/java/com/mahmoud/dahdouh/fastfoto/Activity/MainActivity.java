package com.mahmoud.dahdouh.fastfoto.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // inflate
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle(R.string.discover);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "back", Toast.LENGTH_SHORT).show();
            }
        });

        // set home fragment
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();

        // bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {

                    case R.id.main_btm_home:
                        selectedFragment = new HomeFragment();
                        toolbar.setTitle(R.string.discover);
                        toolbar.getMenu().getItem(1).setVisible(true);
//                        if (toolbar.getMenu() != null)
//                            toolbar.inflateMenu(R.menu.toolbar_menu);
                        break;

                    case R.id.main_btm_category:
                        selectedFragment = new CategoryFragment();
                        toolbar.setTitle(R.string.category);
                        toolbar.getMenu().getItem(1).setVisible(false);
                        break;
                    case R.id.main_btm_favorite:
                        selectedFragment = new FavoriteFragment();
                        toolbar.setTitle(R.string.favorite);
                        toolbar.getMenu().getItem(1).setVisible(false);

                        break;

                    case R.id.main_btm_search:
                        selectedFragment = new SearchFragment();
                        toolbar.setTitle(R.string.search);
                        toolbar.getMenu().getItem(1).setVisible(false);
                        break;
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.container, selectedFragment)
                        .commit();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        //MenuItem searchItem = menu.findItem(R.id.toolbar_home_search);
        MenuItem search = menu.findItem(R.id.toolbar_home_search);

        //SearchView searchView = (SearchView) searchItem.getActionView();
        SearchView searchView = (SearchView) search.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "search done", Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Search", "onQueryTextChange: " + newText);

                return false;
            }
        });


        // @deprecated Use {@link MenuItem#getActionView()} directly.
        return true;
    }


}
