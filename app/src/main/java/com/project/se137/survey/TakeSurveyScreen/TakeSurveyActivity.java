package com.project.se137.survey.TakeSurveyScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.project.se137.survey.R;
import com.project.se137.survey.SingleFragmentActivity;

/**
 * Created by Johnny on 11/9/15.
 */
public class TakeSurveyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new TakeSurveyFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call superclass code for onCreate()
        super.onCreate(savedInstanceState);

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
            fm.beginTransaction().add(R.id.survey_fragment_container, fragment).commit();
        }

        Intent i = getIntent();
        String surveyName = i.getStringExtra(TakeSurveyFragment.SURVEY_ID);

    }
}
