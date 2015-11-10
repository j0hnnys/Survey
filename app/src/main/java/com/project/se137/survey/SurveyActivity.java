package com.project.se137.survey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Johnny on 11/9/15.
 */
public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call superclass code to to initial setup for onCreate()
        super.onCreate(savedInstanceState);

        // Set the view to be that of the layout file: fragment_survey_template.xml
        setContentView(R.layout.fragment_survey_template);

        
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.survey_fragment_container);

        if (fragment == null) {
            fragment = new SurveyFragment();
            fm.beginTransaction().add(R.id.survey_fragment_container, fragment).commit();
        }
    }
}
