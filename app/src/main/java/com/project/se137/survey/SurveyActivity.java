package com.project.se137.survey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Johnny on 11/9/15.
 */
public class SurveyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new SurveyFragment();
    }
}
