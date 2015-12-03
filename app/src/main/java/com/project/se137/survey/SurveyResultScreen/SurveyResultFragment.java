package com.project.se137.survey.SurveyResultScreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.project.se137.survey.Question;
import com.project.se137.survey.R;
import com.project.se137.survey.SurveyListScreen.SurveyListActivity;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by Johnny on 12/2/15.
 */
public class SurveyResultFragment extends Fragment {

    private String surveyName;
    private LinearLayout linearLayout;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_survey_result, container, false);
        // Set linear layout to one in xml file
        linearLayout = (LinearLayout) v.findViewById(R.id.layout_survey_result);
        // Context is used often for creating new views, so we create a class variable for that
        context = getActivity();

        // Grab the name of the survey selected from list
        Bundle args = getArguments();
        surveyName = args.getString(SurveyListActivity.SURVEY_ID);

        final LinearLayout finalLinearLayout = linearLayout;
        // Query Parse database
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
        query.whereEqualTo("surveyName", surveyName);

        try {
            ArrayList<Question> questions = generateQuestionsArray(query.find());

            for (Question q : questions) {
                addQuestionSet(q);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return v;
    }

<<<<<<< HEAD
    private ArrayList<Question> generateQuestionsArray(List<ParseObject> objects) {

        ArrayList<Question> questions = new ArrayList<Question>();

        for (ParseObject obj : objects) {
            String question = obj.getString("question");
            List<String> answers = obj.getList("possibleAnswers");
            boolean multi = obj.getBoolean("multi");
            Question q = new Question(question, answers, multi);
            questions.add(q);
        }

        return questions;
    }

    /**
     * Adds a question and its set of answers to the layout view
     * @param q the Question class that contains the QA information
     */
    private void addQuestionSet(Question q) {

        // Add question to layout
        TextView questionToAdd = new TextView(getActivity());
        questionToAdd.setText(q.getQuestion());

        linearLayout.addView(questionToAdd);
        linearLayout.addView(createResultSet(q));

    }

    private LinearLayout createResultSet(Question q) {

        // Create parse object and query database
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Results");
        // Filter query to find questions related to survey
        query.whereEqualTo("surveyName", surveyName);
        // Filter query to find exact question
        query.whereEqualTo("question", q.getQuestion());

        // Create horizontal layout for result & result name
        LinearLayout subLayout = new LinearLayout(context);
        subLayout.setOrientation(LinearLayout.VERTICAL);

        List<String> answers = q.getPossibleAnswers();

        // For every answer in the question, create a result set
        for (int i = 0; i < answers.size(); i++) {
            // resultName = name of answer choice
            TextView resultName = new TextView(context);
            resultName.setText(answers.get(i));

            // get results from parse and set text to textview
            TextView resultNumber = new TextView(context);

            try {
                List<ParseObject> objects = query.find();
                System.out.println(objects.get(0).getString("surveyName"));
                System.out.println(objects.get(0).getString("question"));
                System.out.println("SHOULD BE A : " + "A" + String.valueOf(i + 1));
                System.out.println("SHOULD BE AN INT : " + objects.get(0).getNumber("A" + String.valueOf(i+1)).intValue());
                int resultNum = objects.get(0).getNumber("A" + String.valueOf(i+1)).intValue();
                resultNumber.setText(String.valueOf(resultNum));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            resultNumber.setPadding(0, 0, 50, 0);

            LinearLayout subL = new LinearLayout(context);
            subL.setOrientation(LinearLayout.HORIZONTAL);
            subL.addView(resultNumber);
            subL.addView(resultName);

            subLayout.addView(subL);
        }

        return subLayout;
=======
    private ArrayList<Integer> getPercents(ArrayList<Integer> results){
        ArrayList<Integer> percents = new ArrayList<>();

        Integer totalResults = 0;
        for(int result : results){
            totalResults += result;
        }

        for(int result : results){
            percents.add((result / totalResults) * 100);
        }

        return percents;
>>>>>>> origin/master
    }
}
