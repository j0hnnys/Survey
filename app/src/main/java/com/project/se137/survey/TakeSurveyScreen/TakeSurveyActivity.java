package com.project.se137.survey.TakeSurveyScreen;

import android.support.v4.app.Fragment;

import com.project.se137.survey.SingleFragmentActivity;

/**
 * Created by Johnny on 11/9/15.
 */
public class TakeSurveyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new TakeSurveyFragment();
    }
}