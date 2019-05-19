package com.Light.lightbrowser.WelComeSplash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.Light.lightbrowser.Activities.MainActivity;
import com.Light.lightbrowser.R;

public class WelComeSplashActivity extends AppCompatActivity {
    private static final String TAG = "WelComeSplashActivity";

    private Animation fromto;
    private LinearLayout lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come_splash);

        lin=findViewById(R.id.splash_lin);
        fromto= AnimationUtils.loadAnimation(this,R.anim.fromto);
        lin.startAnimation(fromto);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(WelComeSplashActivity.this, MainActivity.class);
                startActivity(intent);

            }
        },2000);
    }
}
