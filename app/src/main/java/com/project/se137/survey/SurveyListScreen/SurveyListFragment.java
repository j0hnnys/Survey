package com.project.se137.survey.SurveyListScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.project.se137.survey.GlobalVariable;
import com.project.se137.survey.R;
import com.project.se137.survey.Survey;
import com.project.se137.survey.SurveyResultScreen.SurveyResultActivity;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyActivity;
import com.project.se137.survey.TakeSurveyScreen.TakeSurveyFragment;

import java.util.List;


/**
 * Created by Johnny on 11/23/15.
 */
public class SurveyListFragment extends Fragment {

    private RecyclerView surveyRecyclerView;
    private SurveyAdapter surveyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_survey_list, container, false);

        // Initialize surveyRecyclerView
        surveyRecyclerView = (RecyclerView) view.findViewById(R.id.survey_recycler_view);

        // IMPORTANT:
        // RecyclerView requires a LayoutManager to work. IT WILL CRASH IF YOU FORGET ONE.
        surveyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Survey");

        List<ParseObject> objects;
        try {
            objects = query.find();
            surveyAdapter = new SurveyAdapter(objects);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        surveyRecyclerView.setAdapter(surveyAdapter);

        return view;
    }

    private class SurveyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button surveyNameButton;

        public SurveyHolder(View itemView) {
            super(itemView);

            // Initialize name of survey inside SurveyHolder
            surveyNameButton = (Button) itemView.findViewById(R.id.list_survey_name_button);

            surveyNameButton.setOnClickListener(this);
        }

        // Bind survey to the holder and set name accordingly
        public void bindSurvey(Survey s) {
            surveyNameButton.setText(s.getName());
        }

        // Initializes TakeSurveyActivity when user selects a survey to take
        @Override
        public void onClick(View v) {
            Intent intent = customGetIntent();
            intent.putExtra(SurveyListActivity.SURVEY_ID, surveyNameButton.getText().toString());
            startActivity(intent);
        }
    }

    /**
     * Checks for whether activitySwitch is 0 or 1 to determine whether
     * to return Intent with TakeSurveyActivity or SurveyResultActivity
     * @return Intent that varies depending on activitySwitch's value.
     */
    private Intent customGetIntent() {

        if (GlobalVariable.result == 0) {
            return new Intent(getActivity(), TakeSurveyActivity.class);
        } else {
            return new Intent(getActivity(), SurveyResultActivity.class);
        }
    }

    private class SurveyAdapter extends RecyclerView.Adapter<SurveyHolder> {

        private List<ParseObject> surveyObjects;

        public SurveyAdapter(List<ParseObject> sObjects) {
            surveyObjects = sObjects;
        }

        @Override
        public SurveyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create the LayoutInflater that is used to inflate the CrimeHolder (ViewHolder)
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            // Inflates each individual SurveyHolder (ViewHolder) using
            //  the generic xml template list_item_survey.xml
            View view = layoutInflater.inflate(R.layout.list_item_survey, parent, false);

            return new SurveyHolder(view);
        }

        @Override
        public void onBindViewHolder(SurveyHolder holder, int position) {
            ParseObject parseObject = surveyObjects.get(position);
            String surveyName = parseObject.getString("surveyName");
            Survey survey = new Survey(surveyName);
            holder.bindSurvey(survey);
        }

        @Override
        public int getItemCount() {
            return surveyObjects.size();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

}
