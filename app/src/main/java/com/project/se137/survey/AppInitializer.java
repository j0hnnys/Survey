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

//        ParseObject account = new ParseObject("User");
//        account.put("username", "password");
//        account.saveInBackground();



        //Adds a test question on startup to Parse DB
//        ParseObject newQuestion = new ParseObject("Questions");
//        newQuestion.put("surveyName", "TestSurvey");
//        newQuestion.put("question","Which classes are you taking this semester?");
//        newQuestion.put("multi", true);
//        newQuestion.addAll("possibleAnswers", Arrays.asList("CMPE137","CMPE172","CMPE195A","CMPE19B") );
//        newQuestion.saveInBackground();

//        ParseObject testObject = new ParseObject("TestObject");
//        testObject.put("foo", "bar");
//        testObject.saveInBackground();

        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}