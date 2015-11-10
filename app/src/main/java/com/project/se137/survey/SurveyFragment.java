package com.project.se137.survey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Johnny on 11/9/15.
 */
public class SurveyFragment extends Fragment {

    LinearLayout 

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_survey_template, container, false);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
