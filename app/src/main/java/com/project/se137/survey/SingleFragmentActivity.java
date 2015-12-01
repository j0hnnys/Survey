package com.project.se137.survey;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseObject;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyFragment;


/**
 * Created by Johnny on 11/10/15.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call superclass code for onCreate()
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String surveyName = i.getStringExtra(TakeSurveyFragment.SURVEY_ID);
        Bundle args = new Bundle();
        args.putString(TakeSurveyFragment.SURVEY_ID, surveyName);

        // Set the view to be that of the layout file: fragment_survey_template.xml
        setContentView(R.layout.fragment_survey_template);

        // Get support Fragment manager
        FragmentManager fm = getSupportFragmentManager();
        // Create fragment and set it to fragment located in fragment_survey_template.xml
        Fragment fragment = fm.findFragmentById(R.id.survey_fragment_container);

        // Error handling here; sometimes the target fragment might not exist so it
        // is always good to check that.
        if (fragment == null) {
            fragment = getFragment();
            fragment.setArguments(args);
            fm.beginTransaction().add(R.id.survey_fragment_container, fragment).commit();
        }
    }
}