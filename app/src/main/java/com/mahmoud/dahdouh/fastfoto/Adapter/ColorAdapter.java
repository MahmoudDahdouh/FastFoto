package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.Color;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewholder> {

    private List<Color> colorList = new ArrayList<>();

    public void setColorList(List<Color> ColorList) {
        this.colorList = ColorList;
    }

    @NonNull
    @Override
    public ColorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ColorViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_color, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    class ColorViewholder extends RecyclerView.ViewHolder {

        // Declere your views
        private LinearLayout view;

        public ColorViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            view = itemView.findViewById(R.id.listitem_color_circle);
        }

        private void bind(int position) {

            // Bind data
            view.setBackgroundResource(colorList.get(position).getColor_id());
        }
    }
}
