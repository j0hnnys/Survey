package com.project.se137.survey.MainStartScreen;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.se137.survey.CreateSurveyScreen.CreateSurveyActivity;
import com.project.se137.survey.LogInScreen.LogInActivity;
import com.project.se137.survey.MainStartScreen.MainActivity;
import com.project.se137.survey.R;
import com.project.se137.survey.SurveyResultScreen.SurveyListActivity;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyActivity;


public class MainFragment extends Fragment {
    Button createSurveyButton;
    Button takeSurveyButton;
    Button resultsButton;
    Button logInButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // initialize buttons
        createSurveyButton = (Button) v.findViewById(R.id.create_survey_button);
        takeSurveyButton = (Button) v.findViewById(R.id.take_survey_button);
        resultsButton = (Button) v.findViewById(R.id.results_button);
        logInButton = (Button) v.findViewById(R.id.log_in_button);

        //CREATE -> CreateSurveyActivity
        createSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateSurveyActivity.class);
                startActivity(intent);
            }
        });

        //SURVEYS -> TakeSurveyActivity
        takeSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SurveyListActivity.class);
                startActivity(intent);
            }
        });

        //RESULTS ->
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        //LOG IN -> LogInActivity
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogInActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
