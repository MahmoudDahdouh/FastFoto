package com.mahmoud.dahdouh.fastfoto.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.mahmoud.dahdouh.fastfoto.Adapter.OnboardingAdapter;
import com.mahmoud.dahdouh.fastfoto.Model.OnboardingModel;
import com.mahmoud.dahdouh.fastfoto.R;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 mViewpager;
    private OnboardingAdapter adapter;
    private List<OnboardingModel> onboardingModelList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button btn_next, btn_back;
    private int current_item = 0;
    private ImageView indicator_1, indicator_2, indicator_3;
    private ImageView[] indicators;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        // inflate
        mViewpager = findViewById(R.id.onboarding_viewpager);
        btn_back = findViewById(R.id.onboarding_back_btn);
        btn_next = findViewById(R.id.onboarding_next_btn);

        // indicators
        indicator_1 = findViewById(R.id.indicator_1);
        indicator_2 = findViewById(R.id.indicator_2);
        indicator_3 = findViewById(R.id.indicator_3);

        indicator_1.setImageResource(R.drawable.onbroading_indicator_active);
        indicator_2.setImageResource(R.drawable.onbroading_indicator_inactive);
        indicator_3.setImageResource(R.drawable.onbroading_indicator_inactive);

        onboardingModelList = new ArrayList<>();
        onboardingModelList.add(new OnboardingModel("+1 Million image", getString(R.string.lorem), R.drawable.ic_million_image));
        onboardingModelList.add(new OnboardingModel("Download free", getString(R.string.lorem), R.drawable.ic_image_free));
        onboardingModelList.add(new OnboardingModel("Share with friends", getString(R.string.lorem), R.drawable.ic_share_with_friends));

        adapter = new OnboardingAdapter();
        adapter.setOnboardingModelList(onboardingModelList);

        mViewpager.setAdapter(adapter);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        mViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                current_item = position;
                if (current_item == 2) {
                    btn_next.setText(R.string.skip);
                    btn_back.setVisibility(View.VISIBLE);

                    indicator_1.setImageResource(R.drawable.onbroading_indicator_inactive);
                    indicator_2.setImageResource(R.drawable.onbroading_indicator_inactive);
                    indicator_3.setImageResource(R.drawable.onbroading_indicator_active);
                } else if (position == 1) {
                    btn_next.setText(R.string.next);
                    btn_back.setVisibility(View.VISIBLE);

                    indicator_1.setImageResource(R.drawable.onbroading_indicator_inactive);
                    indicator_2.setImageResource(R.drawable.onbroading_indicator_active);
                    indicator_3.setImageResource(R.drawable.onbroading_indicator_inactive);
                } else if (position == 0) {
                    btn_back.setVisibility(View.INVISIBLE);

                    indicator_1.setImageResource(R.drawable.onbroading_indicator_active);
                    indicator_2.setImageResource(R.drawable.onbroading_indicator_inactive);
                    indicator_3.setImageResource(R.drawable.onbroading_indicator_inactive);
                }
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_item == 2) {
                    startActivity(new Intent(OnboardingActivity.this, MainActivity.class));
                    editor.putInt("ONCE", 1);
                    editor.apply();
                    finish();
                }
                mViewpager.setCurrentItem(current_item + 1);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewpager.setCurrentItem(current_item - 1);
            }
        });

    }

    public void next(View view) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        /*if (sharedPreferences.getInt("ONCE", 0) != 0) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }*/
    }
}
