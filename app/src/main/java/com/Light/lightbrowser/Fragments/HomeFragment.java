package com.Light.lightbrowser.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Light.lightbrowser.Activities.MainActivity;
import com.Light.lightbrowser.Activities.SearchActivity;
import com.Light.lightbrowser.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";
    private EditText edt_url;
    private Button search_btn;
    private View view;

    private Button facebookBtn, youtubeBtn, instagramBtn, snapchatBtn, yahooBtn, googleBtn;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        setupSearch();
        return view;

    }

    private void init() {
        edt_url = view.findViewById(R.id.edt_url);
        search_btn = view.findViewById(R.id.btn_search);
        facebookBtn = view.findViewById(R.id.facebookBtn);
        youtubeBtn = view.findViewById(R.id.youtubeBtn);
        instagramBtn = view.findViewById(R.id.instagramBtn);
        snapchatBtn = view.findViewById(R.id.snapchatBtn);
        yahooBtn = view.findViewById(R.id.yahooBtn);
        googleBtn = view.findViewById(R.id.googleBtn);


    }

    private void setupSearch() {

        search_btn.setOnClickListener(this);
        facebookBtn.setOnClickListener(this);
        youtubeBtn.setOnClickListener(this);
        instagramBtn.setOnClickListener(this);
        snapchatBtn.setOnClickListener(this);
        yahooBtn.setOnClickListener(this);
        googleBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_search:
                searchWeb();
                break;
            case R.id.facebookBtn:
                Intent open_facebook = new Intent(getActivity(), SearchActivity.class);
                open_facebook.putExtra("url","https://www.facebook.com");
                startActivity(open_facebook);
                break;
            case R.id.youtubeBtn:
                Intent open_youtube = new Intent(getActivity(), SearchActivity.class);
                open_youtube.putExtra("url","https://www.youtube.com");
                startActivity(open_youtube);
                break;
            case R.id.instagramBtn:
                Intent open_insta = new Intent(getActivity(), SearchActivity.class);
                open_insta.putExtra("url","https://www.instagram.com");
                startActivity(open_insta);
                break;
            case R.id.snapchatBtn:
                Intent open_snapchat = new Intent(getActivity(), SearchActivity.class);
                open_snapchat.putExtra("url","https://www.snapchat.com");
                startActivity(open_snapchat);
                break;
            case R.id.yahooBtn:
                Intent open_yahoo = new Intent(getActivity(), SearchActivity.class);
                open_yahoo.putExtra("url","https://www.yahoo.com");
                startActivity(open_yahoo);
                break;
            case R.id.googleBtn:
                Intent open_google = new Intent(getActivity(), SearchActivity.class);
                open_google.putExtra("url","https://www.google.com");
                startActivity(open_google);
                break;

        }

    }

    private void searchWeb() {

        String url=edt_url.getText().toString();
        if (TextUtils.isEmpty(url)){
            Toast.makeText(getActivity(), "Url should not be Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent searchIntent= new Intent(getActivity(),SearchActivity.class);
            String url_without_https=url.replaceAll("https://","");
            String https="https://";
            String www="www.";
            searchIntent.putExtra("url",https+www+url_without_https);
            startActivity(searchIntent);
        }
    }
}
