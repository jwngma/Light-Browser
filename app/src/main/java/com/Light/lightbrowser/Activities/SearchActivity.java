package com.Light.lightbrowser.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.Light.lightbrowser.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SearchActivity";

    private EditText search_url;
    private ImageView searchBtn;
    private WebView webView;
    private String url;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Log.d(TAG, "onCreate: serach Activity is created");

        if (getIntent()!=null){
            url=getIntent().getStringExtra("url");

        }

        init();
        initWeb();
        onClick();
        setupBottomNavigation();

        search_url.setText(url);
    }

    private void setupBottomNavigation() {
        navigationView=findViewById(R.id.search_navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_back:
                        onBackPressed();
                        break;
                    case R.id.nav_forward:
                        onForwardPressed();
                        break;
                    case R.id.nav_menu:

                        break;
                    case R.id.nav_tabs:
                        break;
                    case R.id.nav_home:
                        loadHome();
                        break;

                }

                return true;
            }
        });
    }

    private void loadHome() {
        Intent intent= new Intent(SearchActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void onClick() {
        searchBtn.setOnClickListener(this);
    }

    private void initWeb() {
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }

    private void init() {
        search_url=findViewById(R.id.edt_url);
        searchBtn=findViewById(R.id.btn_search);
        webView=findViewById(R.id.webview);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_search:
                searchWeb();
                break;
        }

    }

    private void searchWeb() {
        String url=search_url.getText().toString();

        if (TextUtils.isEmpty(url)){
            Toast.makeText(this, "Url should not be Empty to Proceed", Toast.LENGTH_SHORT).show();
        }
        else {
            String url_without_https=url.replaceAll("htpps://","");
            String htpps="https://";
            String www="www.";
            Intent intent= new Intent(SearchActivity.this,SearchActivity.class);
            intent.putExtra("url",htpps+www+url_without_https);
            startActivity(intent);

            search_url.setText("");
            search_url.requestFocus();
        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.app_logo)
                    .setTitle("Are you sure you want to exit?")
                    .setMessage("Tapping 'Yes' will close the app. Tap 'No' to continue using the app")
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    finish();
                                }
                            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .show();
        }

    }

    protected  void onForwardPressed(){
       if (webView.canGoForward()){
           webView.goForward();
       }else {
           Toast.makeText(this, "Cant go Further", Toast.LENGTH_SHORT).show();
       }
    }


}
