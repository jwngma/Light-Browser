package com.Light.lightbrowser.Activities;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.Light.lightbrowser.Fragments.AppsFragment;
import com.Light.lightbrowser.Fragments.HistoryFragment;
import com.Light.lightbrowser.Fragments.HomeFragment;
import com.Light.lightbrowser.Fragments.ServicesFragment;
import com.Light.lightbrowser.Fragments.WalletFragment;
import com.Light.lightbrowser.R;

public class MainActivity extends AppCompatActivity   {

    private static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    private RelativeLayout alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alpha=findViewById(R.id.alpha);

        setupBottomNavigation();
        sutUpFragment(new HomeFragment());
    }

    private void setupBottomNavigation() {

        bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        sutUpFragment(new HomeFragment());
                        break;
                    case R.id.nav_app:
                        sutUpFragment(new AppsFragment());
                        alpha.setAlpha(0);
                        break;
                    case R.id.nav_services:
                        sutUpFragment(new ServicesFragment());
                        alpha.setAlpha(0);
                        break;
                    case R.id.nav_wallet:
                        sutUpFragment(new WalletFragment());
                        alpha.setAlpha(0);
                        break;
                    case R.id.nav_acccount:
                        sutUpFragment(new HistoryFragment());
                        alpha.setAlpha(0);
                        break;
                }
                return true;
            }
        });
    }
    public void sutUpFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}
