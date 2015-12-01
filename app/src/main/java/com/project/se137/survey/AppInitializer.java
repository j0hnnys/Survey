package com.project.se137.survey;

import android.app.Application;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stephenpiazza on 11/18/15.
 */
public class AppInitializer extends Application {

    @Override public void onCreate() {
        super.onCreate();

        //Initializes conection to Parse with applicationID and clientID provided by Parse
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
        //DEBUG
        Log.d("TAG", "Parse enabled");
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}