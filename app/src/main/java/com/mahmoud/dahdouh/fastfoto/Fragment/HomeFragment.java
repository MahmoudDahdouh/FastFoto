package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.mahmoud.dahdouh.fastfoto.Adapter.CategoryAdapter;
import com.mahmoud.dahdouh.fastfoto.Adapter.ViewpagerAdapter;
import com.mahmoud.dahdouh.fastfoto.Model.CategoryName;
import com.mahmoud.dahdouh.fastfoto.Model.Page;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Toolbar toolbar;
    private ViewPager2 viewPager2;
    private RecyclerView popularRecycler, categoriesRecycler;
    private List<CategoryName> categoryNames;
    private List<Page> pages;
    private CategoryAdapter categoryAdapter;
    private ViewpagerAdapter pagerAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_home, container, false);

        // set toolbar
        toolbar = layout.findViewById(R.id.toolbar_home);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toolbar_home_search:
                        Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        // end toolbar

        // viewpager 2
        viewPager2 = layout.findViewById(R.id.home_viewpager);

        pages = new ArrayList<>();
        pages.add(new Page(R.drawable.cat));
        pages.add(new Page(R.drawable.car));
        pages.add(new Page(R.drawable.building));
        pages.add(new Page(R.drawable.flower));

        pagerAdapter = new ViewpagerAdapter();
        pagerAdapter.setPageList(pages);
        viewPager2.setAdapter(pagerAdapter);

        categoriesRecycler = layout.findViewById(R.id.home_recycler_category);
        popularRecycler = layout.findViewById(R.id.home_recycler_popular);


        //


        // recycler popular
        popularRecycler = layout.findViewById(R.id.home_recycler_popular);
        popularRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        return layout;
    }

}
