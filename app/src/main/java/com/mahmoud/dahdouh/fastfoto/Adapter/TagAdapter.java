package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.Tag;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewholder> {

    private List<Tag> tagList = new ArrayList<>();

    public void setTagList(List<Tag> TagList) {
        this.tagList = TagList;
    }

    @NonNull
    @Override
    public TagViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TagViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    class TagViewholder extends RecyclerView.ViewHolder {

        // Declere your views
        private TextView name;

        public TagViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            name = itemView.findViewById(R.id.listitem_tag_name);
        }

        private void bind(int position) {
            // Bind data
            name.setText(tagList.get(position).getName());
        }
    }
}
