package com.project.se137.survey;

import android.support.v4.app.Fragment;

/**
 * Created by danielnguyen on 11/23/15.
 */
public class LogInActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new LogInFragment();
    }
}