package com.project.se137.survey.SurveyResultScreen;

import android.support.v4.app.Fragment;

import com.project.se137.survey.SingleFragmentActivity;

/**
 * Created by Johnny on 11/23/15.
 */
public class SurveyListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SurveyListFragment();
    }
}
