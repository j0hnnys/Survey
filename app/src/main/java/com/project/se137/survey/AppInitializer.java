package com.project.se137.survey;

import android.app.Application;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Johnny Nguyen on 11/2/15.
 */
public class AppInitializer extends Application {

    @Override public void onCreate() {
        super.onCreate();

        // ApplicationID is unique to the Parse database the app is associated with
        //Initializes conection to Parse with applicationID and clientID provided by Parse
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "jHi5qznicVuK1osvrqlks7vSbOsRMDctGHHr0tXd",
                "pWLM1nizogLHEkE0aCxC7CwFh2rebWoGN1Iw3n61");


        //DEBUG
        Log.d("TAG", "Parse enabled");
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}