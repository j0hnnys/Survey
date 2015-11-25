package com.project.se137.survey;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielnguyen on 11/25/15.
 */
public class TakeSurveyFragment extends Fragment {

    LinearLayout surveyLayout;
    Context context;
    //declare a class variable that will hold a list of Questions.
    private List<Question> surveys;

//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
//        View v = inflater.inflate(R.layout.fragment_survey_template, container, false);
//
//        // Set surveyLayout to be LinearLayout in fragment layout file
//        surveyLayout = (LinearLayout) v.findViewById(R.id.survey_fragment_container);
//
//        // Set context to be getActivity. This is used repeatedly to create views in code.
//        context = getActivity();
//    }

}
