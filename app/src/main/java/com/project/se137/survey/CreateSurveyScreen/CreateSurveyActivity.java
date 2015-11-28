package com.project.se137.survey.CreateSurveyScreen;

import android.support.v4.app.Fragment;

import com.project.se137.survey.SingleFragmentActivity;

/**
 * Created by Johnny on 11/16/15.
 */
public class CreateSurveyActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CreateSurveyFragment();
    }
}
