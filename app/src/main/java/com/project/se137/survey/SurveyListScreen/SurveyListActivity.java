package com.project.se137.survey.SurveyListScreen;

import android.support.v4.app.Fragment;

import com.project.se137.survey.SingleFragmentActivity;

/**
 * Created by Johnny on 11/23/15.
 */
public class SurveyListActivity extends SingleFragmentActivity {

    public static final String SURVEY_ID = "SURVEY";

    @Override
    protected Fragment getFragment() {
        return new SurveyListFragment();
    }
}
