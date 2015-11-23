package com.project.se137.survey;

import android.support.v4.app.Fragment;

import com.project.se137.survey.SingleFragmentActivity;
import com.project.se137.survey.SurveyFragment;

/**
 * Created by calvin on 11/23/2015.
 */
public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new MainFragment();
    }
}
