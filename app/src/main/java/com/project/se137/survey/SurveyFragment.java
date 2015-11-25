package com.project.se137.survey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Johnny on 11/9/15.
 */
public class SurveyFragment extends Fragment {

    LinearLayout surveyLayout;
    Context context;
    ArrayList<Question> questions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_survey_template, container, false);

        // Set surveyLayout to be LinearLayout in fragment layout file
        surveyLayout = (LinearLayout) v.findViewById(R.id.survey_fragment_container);

        // Set context to be getActivity. This is used repeatedly to create views in code.
        context = getActivity();

//        System.out.println("Begin Querying Server...");
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
//        query.whereEqualTo("surveyName", "TestSurvey");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            public void done(List<ParseObject> results, ParseException e) {
//                if (e == null) {
//                    System.out.println("Query Successfull");
//                    for (ParseObject object: results) {
//                        String questionText = object.getString("question");
//                        Boolean multi = object.getBoolean("multi");
//                        List<String> possibleAnswers = object.getList("possibleAnswers");
//                        System.out.println(questionText + " " + multi + " "  +possibleAnswers.toString());
//                        Question question = new Question(questionText, multi, possibleAnswers);
//                        questions.add(question);
//                    }
//                }
//                else {
//                    System.out.println("Query Failed");
//                }
//            }
//        });

        // TEST CODE BELOW
        ArrayList<String> answers = new ArrayList<>();
        answers.add("SE");
        answers.add("CMPE");

        Question q = new Question("Are you an SE or CMPE major?", answers,  false, "Admin");
        addQuestionSet(q);

        return v;
    }

    /**
     * Adds a question and its set of answers to the layout view
     * @param q the Question class that contains the QA information
     */
    private void addQuestionSet(Question q) {
        // Add question to layout
        TextView question = new TextView(getActivity());
        question.setText(getString(R.string.creator_and_question_placeholder, q.getCreator(), q.getQuestion()) );
        surveyLayout.addView(question);

        // Add answers corresponding to question
        View view;
        if (q.isMultiAnswer()) { // Create CheckBoxes if true
            view = createCheckBoxGroup(q.getPossibleAnswers());
        } else { // else create radiogroup
            view = createRadioGroup(q.getPossibleAnswers());
        }

        surveyLayout.addView(view);
    }

    /**
     * Given a list of answers, creates and returns a group of radio buttons
     * @param answers answers to create radio buttons from
     * @return radiogroup representing collection of answers
     */
    private RadioGroup createRadioGroup(List<String> answers) {
        RadioGroup radioGroup = new RadioGroup(context);

        // Loop through answer list and add a radio button for each one.
        for (String answer : answers) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(answer);
            radioGroup.addView(radioButton);
        }

        return radioGroup;
    }

    /**
     * Given a list of answers, creates and returns a group of CheckBox views contained
     * within a LinearLayout groupview.
     * @param answers answers to create CheckBoxes from
     * @return LinearLayout containing the collection of answers
     */
    private LinearLayout createCheckBoxGroup(List<String> answers) {
        LinearLayout linearLayout = new LinearLayout(context);

        // Loop through answer list and add a CheckBox to linearLayout for each one.
        for (String answer : answers) {
            CheckBox checkbox = new CheckBox(context);
            checkbox.setText(answer);
            linearLayout.addView(checkbox);
        }

        return linearLayout;
    }
}
