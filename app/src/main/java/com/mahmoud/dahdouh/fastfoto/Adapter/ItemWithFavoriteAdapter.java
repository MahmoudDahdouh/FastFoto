package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.ItemWithFavorite;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class ItemWithFavoriteAdapter extends RecyclerView.Adapter<ItemWithFavoriteAdapter.MyViewholder> {

    private List<ItemWithFavorite> itemWithFavoriteList = new ArrayList<>();

    public void setItemWithFavoriteList(List<ItemWithFavorite> ItemWithFavoriteList) {
        this.itemWithFavoriteList = ItemWithFavoriteList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemWithFavoriteList.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder {

        // Declere your views
        private TextView name;
        private ImageView imageView;
        private ToggleButton favorite;


        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            name = itemView.findViewById(R.id.listitem_image_title);
            imageView = itemView.findViewById(R.id.listitem_image_image);
            favorite = itemView.findViewById(R.id.listitem_image_toggle);
        }

        private void bind(int position) {
            // Bind data
            name.setText(itemWithFavoriteList.get(position).getName());
            imageView.setImageResource(itemWithFavoriteList.get(position).getImage());
            favorite.setChecked(itemWithFavoriteList.get(position).isFavorite());


            favorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    itemWithFavoriteList.get(getAdapterPosition()).setFavorite(isChecked);
                }
            });
        }
    }
}
