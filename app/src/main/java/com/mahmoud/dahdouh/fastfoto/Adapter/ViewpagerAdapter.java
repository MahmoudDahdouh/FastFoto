package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.Page;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends RecyclerView.Adapter<ViewpagerAdapter.PageViewholder> {

    private List<Page> PageList = new ArrayList<>();

    public void setPageList(List<Page> PageList) {
        this.PageList = PageList;
    }

    @NonNull
    @Override
    public PageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PageViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_viewpager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return PageList.size();
    }

    class PageViewholder extends RecyclerView.ViewHolder {

        // Declere your views
        private ImageView imageView;

        public PageViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            imageView = itemView.findViewById(R.id.listitem_viewpager_image);
        }

        private void bind(int position) {
            // Bind data
            imageView.setImageResource(PageList.get(position).getImage());
        }
    }
}
