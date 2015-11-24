package com.project.se137.survey;

import android.support.v4.app.Fragment;

/**
 * Created by Johnny on 11/23/15.
 */
public class SurveyListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SurveyListFragment();
    }
}
