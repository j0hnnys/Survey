package com.project.se137.survey.MainStartScreen;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.project.se137.survey.CreateSurveyScreen.CreateSurveyActivity;
import com.project.se137.survey.GlobalVariable;
import com.project.se137.survey.LogInScreen.LogInActivity;
import com.project.se137.survey.R;
import com.project.se137.survey.SurveyListScreen.SurveyListActivity;
import com.project.se137.survey.SurveyResultScreen.SurveyResultActivity;


public class MainFragment extends Fragment {
    Button createSurveyButton;
    Button takeSurveyButton;
    Button resultsButton;
    ImageView createSurveyImageView;
    ImageView takeSurveyImageView;
    ImageView surveyResultsImageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // initialize buttons
        createSurveyButton = (Button) v.findViewById(R.id.create_survey_button);
        takeSurveyButton = (Button) v.findViewById(R.id.take_survey_button);
        resultsButton = (Button) v.findViewById(R.id.results_button);

        // initialize image views
        createSurveyImageView = (ImageView) v.findViewById(R.id.create_survey_image_view);
        takeSurveyImageView = (ImageView) v.findViewById(R.id.take_survey_image_view);
        surveyResultsImageView = (ImageView) v.findViewById(R.id.survey_result_image_view);

        //CREATE -> CreateSurveyActivity
        createSurveyButton.setOnClickListener(createSurveyOnClickListener());
        createSurveyImageView.setOnClickListener(createSurveyOnClickListener());
        //SURVEYS -> TakeSurveyActivity
        takeSurveyButton.setOnClickListener(takeSurveyOnClickListener());
        takeSurveyImageView.setOnClickListener(takeSurveyOnClickListener());
        //RESULTS -> SurveyResultActivity
        resultsButton.setOnClickListener(surveyResultOnClickListener());
        surveyResultsImageView.setOnClickListener(surveyResultOnClickListener());

        return v;
    }

    private View.OnClickListener createSurveyOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateSurveyActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener takeSurveyOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SurveyListActivity.class);
                GlobalVariable.result = 0;
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener surveyResultOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SurveyListActivity.class);
                GlobalVariable.result = 1;
                startActivity(intent);
            }
        };
    }
}
