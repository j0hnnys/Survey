package com.project.se137.survey;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stephenpiazza on 11/18/15.
 */
public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        //Initializes conection to Parse with applicationID and clientID provided by Parse
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "jHi5qznicVuK1osvrqlks7vSbOsRMDctGHHr0tXd", "pWLM1nizogLHEkE0aCxC7CwFh2rebWoGN1Iw3n61");
        System.out.println("Parse Connection Succesfull");
        //Adds a test question on startup to Parse DB
//        ParseObject newQuestion = new ParseObject("Questions");
//        newQuestion.put("surveyName", "TestSurvey");
//        newQuestion.put("question","Which classes are you taking this semester?");
//        newQuestion.put("multi", true);
//        newQuestion.addAll("possibleAnswers", Arrays.asList("CMPE137","CMPE172","CMPE195A","CMPE19B") );
//        newQuestion.saveInBackground();

    }
}