package com.mahmoud.dahdouh.fastfoto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoud.dahdouh.fastfoto.Model.OnboardingModel;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewholder> {

    private List<OnboardingModel> onboardingModelList = new ArrayList<>();

    public void setOnboardingModelList(List<OnboardingModel> OnboardingModelList) {
        this.onboardingModelList = OnboardingModelList;
    }

    @NonNull
    @Override
    public OnboardingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_onboarding, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewholder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return onboardingModelList.size();
    }

    class OnboardingViewholder extends RecyclerView.ViewHolder {

        // Declare your views
        private TextView title;
        private TextView description;
        private ImageView image;

        public OnboardingViewholder(@NonNull View itemView) {
            super(itemView);

            // inflate the view
            title = itemView.findViewById(R.id.listitem_onboarding_title);
            description = itemView.findViewById(R.id.listitem_onboarding_description);
            image = itemView.findViewById(R.id.listitem_onboarding_image);
        }

        private void bind(int position) {
            // Bind data
            title.setText(onboardingModelList.get(position).getTitile());
            description.setText(onboardingModelList.get(position).getDescription());
            image.setImageResource(onboardingModelList.get(position).getImage());
        }
    }
}
