package com.Light.lightbrowser.PreferenceManagers;

import android.content.Context;
import android.content.SharedPreferences;

import com.Light.lightbrowser.R;

public class PreferenceManager {


     Context context;
     SharedPreferences sharedPreferences;


    public PreferenceManager(Context context) {
        this.context = context;

        getSharedPreference();
    }

    public void getSharedPreference() {
        sharedPreferences =context.getSharedPreferences(context.getString(R.string.my_preferenec),Context.MODE_PRIVATE);

    }

    public void writePreference(){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preference_key),"INIT_OK");
        editor.commit();

    }

    public boolean checkPreference(){

        boolean status= false;
        if (sharedPreferences.getString(context.getString(R.string.my_preference_key),"null").equals("null")){
            status=false;
        }
        else {
            status=true;
        }

        return status;
    }

    public void clearPreferenec(){
        sharedPreferences.edit().clear().commit();
    }



}
