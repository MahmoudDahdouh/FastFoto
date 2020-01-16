package com.mahmoud.dahdouh.fastfoto.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Adapter.ColorAdapter;
import com.mahmoud.dahdouh.fastfoto.Adapter.TagAdapter;
import com.mahmoud.dahdouh.fastfoto.Model.Color;
import com.mahmoud.dahdouh.fastfoto.Model.Tag;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView historyRecycler, topTagRecycler, colorRecycler;
    private ColorAdapter colorAdapter;
    private TagAdapter tagAdapter;
    private List<Tag> tags;
    private List<Color> colors;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_search, container, false);

        // set toolbar
        toolbar = layout.findViewById(R.id.toolbar_search);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Back", Toast.LENGTH_SHORT).show();
            }
        });

        // end toolbar

        // color recycler
        colorRecycler = layout.findViewById(R.id.search_recycler_color);
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

        // Tag recycler
        topTagRecycler = layout.findViewById(R.id.search_recycler_top_tags);
        historyRecycler = layout.findViewById(R.id.search_recycler_history);

        topTagRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        historyRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        tags = new ArrayList<>();
        tags.add(new Tag("car"));
        tags.add(new Tag("pizza tower"));
        tags.add(new Tag("fireworks"));
        tags.add(new Tag("rose"));
        tags.add(new Tag("baby"));
        tags.add(new Tag("beach"));
        tags.add(new Tag("building"));

        tagAdapter = new TagAdapter();
        tagAdapter.setTagList(tags);

        topTagRecycler.setAdapter(tagAdapter);
        historyRecycler.setAdapter(tagAdapter);

        //
        return layout;
    }

}
