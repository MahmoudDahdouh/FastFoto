package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Adapter.CategoryAdapter;
import com.mahmoud.dahdouh.fastfoto.Adapter.ColorAdapter;
import com.mahmoud.dahdouh.fastfoto.Model.CategoryName;
import com.mahmoud.dahdouh.fastfoto.Model.Color;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView colorRecycler;
    private ColorAdapter colorAdapter;
    private List<Color> colors;

    // category
    private RecyclerView categoryRecycler;
    private CategoryAdapter categoryAdapter;
    private List<CategoryName> categoryNames;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_category, container, false);

        // set toolbar
        toolbar = layout.findViewById(R.id.toolbar_category);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
            }
        });

        // end toolbar

        // recycler color
        colorRecycler = layout.findViewById(R.id.category_recycler_color);
        colorRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        colors = new ArrayList<>();
        colors.add(new Color(R.color.colorAccent));
        colors.add(new Color(android.R.color.holo_red_light));
        colors.add(new Color(android.R.color.holo_blue_light));
        colors.add(new Color(android.R.color.holo_orange_light));
        colors.add(new Color(android.R.color.holo_green_light));
        colors.add(new Color(android.R.color.holo_purple));
        colors.add(new Color(android.R.color.holo_red_dark));
        colors.add(new Color(android.R.color.holo_orange_dark));
        colors.add(new Color(android.R.color.holo_red_dark));
        colors.add(new Color(android.R.color.darker_gray));
        colors.add(new Color(android.R.color.holo_green_dark));
        colors.add(new Color(android.R.color.background_dark));
        colors.add(new Color(android.R.color.white));

        colorAdapter = new ColorAdapter();
        colorAdapter.setColorList(colors);

        colorRecycler.setAdapter(colorAdapter);

        //


        categoryRecycler = layout.findViewById(R.id.category_recycler_category);
        categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        categoryNames = new ArrayList<>();
        categoryNames.add(new CategoryName("Animal", R.drawable.cat));
        categoryNames.add(new CategoryName("Buildings", R.drawable.building));
        categoryNames.add(new CategoryName("Flower", R.drawable.flower));
        categoryNames.add(new CategoryName("Cars", R.drawable.car));


        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setCategoryNameList(categoryNames);

        categoryRecycler.setAdapter(categoryAdapter);

        return layout;
    }

}
