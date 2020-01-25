package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.mahmoud.dahdouh.fastfoto.Adapter.CategoryAdapter;
import com.mahmoud.dahdouh.fastfoto.Adapter.ItemWithFavoriteAdapter;
import com.mahmoud.dahdouh.fastfoto.Adapter.ViewpagerAdapter;
import com.mahmoud.dahdouh.fastfoto.Model.CategoryName;
import com.mahmoud.dahdouh.fastfoto.Model.ItemWithFavorite;
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
    private List<ItemWithFavorite> popularList;
    private CategoryAdapter categoryAdapter;
    private ViewpagerAdapter pagerAdapter;
    private ItemWithFavoriteAdapter popualrAdapter;
    private CompositePageTransformer mTransformer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_home, container, false);

        // set toolbar
//        toolbar = layout.findViewById(R.id.toolbar_home);
//
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
//            }
//        });

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.toolbar_home_search:
//                        Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });
        // end toolbar

        // viewpager 2
        viewPager2 = layout.findViewById(R.id.home_viewpager);

        pages = new ArrayList<>();
        pages.add(new Page(R.drawable.image_1));
        pages.add(new Page(R.drawable.image_2));
        pages.add(new Page(R.drawable.image_3));
        pages.add(new Page(R.drawable.image_4));
        pages.add(new Page(R.drawable.image_5));
        pages.add(new Page(R.drawable.image_6));
        pages.add(new Page(R.drawable.image_7));

        pagerAdapter = new ViewpagerAdapter();
        pagerAdapter.setPageList(pages);
        viewPager2.setAdapter(pagerAdapter);

        categoriesRecycler = layout.findViewById(R.id.home_recycler_category);

        //
        //margin viewpager 2
        viewPager2.setCurrentItem(1);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        //


        // recycler popular
        popularRecycler = layout.findViewById(R.id.home_recycler_popular);
        popularRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        popularList = new ArrayList<>();
        popularList.add(new ItemWithFavorite("Image 1", R.drawable.image_7, true));
        popularList.add(new ItemWithFavorite("Image 2", R.drawable.image_6, false));
        popularList.add(new ItemWithFavorite("Image 3", R.drawable.image_5, true));
        popularList.add(new ItemWithFavorite("Image 4", R.drawable.image_4, false));
        popularList.add(new ItemWithFavorite("Image 5", R.drawable.image_3, false));
        popularList.add(new ItemWithFavorite("Image 6", R.drawable.image_2, true));

        popualrAdapter = new ItemWithFavoriteAdapter();
        popualrAdapter.setItemWithFavoriteList(popularList);

        popularRecycler.setAdapter(popualrAdapter);
        //


        categoriesRecycler = layout.findViewById(R.id.home_recycler_category);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        categoryNames = new ArrayList<>();

        categoryNames.add(new CategoryName("Buildings", R.drawable.building));
        categoryNames.add(new CategoryName("Animal", R.drawable.cat));
        categoryNames.add(new CategoryName("Cars", R.drawable.car));
        categoryNames.add(new CategoryName("Flower", R.drawable.flower));


        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategoryNameList(categoryNames);

        categoriesRecycler.setAdapter(categoryAdapter);


        //
        return layout;
    }

}
