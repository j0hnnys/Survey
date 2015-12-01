package com.project.se137.survey.SurveyResultScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.se137.survey.MainStartScreen.MainActivity;
import com.project.se137.survey.Question;
import com.project.se137.survey.R;
import com.project.se137.survey.Survey;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyActivity;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyFragment;

import java.util.List;


/**
 * Created by Johnny on 11/23/15.
 */
public class SurveyListFragment extends Fragment {

    private List<Question> surveys;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    private class SurveyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Survey survey;
        private TextView surveyNameTextView;

        public SurveyHolder(View itemView) {
            super(itemView);
            // Initialize name of survey inside SurveyHolder
            surveyNameTextView = (TextView) itemView.findViewById(R.id.survey_name_text_view);
        }

        // Bind survey to the holder and set name accordingly
        public void bindSurvey(Survey s) {
            survey = s;
            surveyNameTextView.setText(survey.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra(TakeSurveyFragment.SURVEY_ID, survey.getName());
            startActivity(intent);
        }
    }


}
