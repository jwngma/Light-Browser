package com.Light.lightbrowser.IntroSlider;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.Light.lightbrowser.Activities.MainActivity;
import com.Light.lightbrowser.PreferenceManagers.PreferenceManager;
import com.Light.lightbrowser.R;
import com.Light.lightbrowser.WelComeSplash.WelComeSplashActivity;

public class IntroSliderActivity extends AppCompatActivity  implements View.OnClickListener {
    private static final String TAG = "IntroSliderActivity";

    private ViewPager viewPager;
    private Button skipBtn, nextBtn;
    ViewPagerAdapter adapter;

    private LinearLayout dots_layout;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);

//        if (new PreferenceManager(this).checkPreference()){
//            SplashIntent();
//            finish();
//        }

        if (new PreferenceManager(this).checkPreference()){
            SplashIntent();
            finish();
        }

        if (Build.VERSION.SDK_INT>=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        skipBtn = findViewById(R.id.skipBtn);
        nextBtn = findViewById(R.id.nextBtn);
        skipBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        dots_layout = findViewById(R.id.dots_layout);


        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {


            }

            @Override
            public void onPageSelected(int i) {
                createDots(i);

                if (i==5){
                    skipBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setText("Start");
                }
                else {
                    skipBtn.setVisibility(View.VISIBLE);
                    nextBtn.setText("Next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    private void createDots(int current_position) {
        if (dots_layout != null) {
            dots_layout.removeAllViews();

            dots = new ImageView[6];
            for (int i = 0; i < 6; i++) {
                dots[i]= new ImageView(this);
                if (i==current_position){
                    dots[i].setImageResource(R.drawable.active_dots);

                }
                else {
                    dots[i].setImageResource(R.drawable.inactive_dots);

                }

                LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                dots_layout.addView(dots[i],params);

            }

        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.skipBtn:
                loadHome();
                //new PreferenceManager(this).writePreference();
                new PreferenceManager(this).writePreference();
                break;
            case R.id.nextBtn:
                nextSlide();
                break;
        }
    }
    private void nextSlide() {
        int nextSlide = viewPager.getCurrentItem() + 1;
        if (nextSlide < 6) {
            viewPager.setCurrentItem(nextSlide);
        } else {
            loadHome();
            //new PreferenceManager(this).writePreference();
            new PreferenceManager(this).writePreference();
        }

    }

    private void loadHome() {
        Intent homeIntent = new Intent(IntroSliderActivity.this, MainActivity.class);
        startActivity(homeIntent);
    }

    private void SplashIntent(){
        Intent intent= new Intent(IntroSliderActivity.this, WelComeSplashActivity.class);
        startActivity(intent);
    }



}
