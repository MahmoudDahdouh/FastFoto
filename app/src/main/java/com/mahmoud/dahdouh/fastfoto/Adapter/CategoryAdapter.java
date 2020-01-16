package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.CategoryName;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewholder> {

    private List<CategoryName> CategoryNameList = new ArrayList<>();

    public void setCategoryNameList(List<CategoryName> CategoryNameList) {
        this.CategoryNameList = CategoryNameList;
    }

    @NonNull
    @Override
    public CategoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return CategoryNameList.size();
    }

    class CategoryViewholder extends RecyclerView.ViewHolder {

        // Declere your views
        private TextView name;
        private ImageView img;

        public CategoryViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            name = itemView.findViewById(R.id.listitem_category_name);
            img = itemView.findViewById(R.id.listitem_category_img);
        }

        private void bind(int position) {
            // Bind data
            name.setText(CategoryNameList.get(position).getName());
            img.setImageResource(CategoryNameList.get(position).getImg());
        }
    }
}
