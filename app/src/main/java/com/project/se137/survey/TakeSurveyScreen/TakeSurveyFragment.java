package com.project.se137.survey.TakeSurveyScreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.project.se137.survey.MainStartScreen.MainActivity;
import com.project.se137.survey.Question;
import com.project.se137.survey.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Johnny on 11/9/15.
 */
public class TakeSurveyFragment extends Fragment {

    private LinearLayout surveyLayout;
    private Context context;
    private Button submitSelectionButton;

    private ArrayList<View> answerViews;
    private String selectedSurvey;

    public static final String SURVEY_ID = "SURVEY";

    // For parse queries and saves
    private static final int VIEW_TAG_1 = 1280504020;
    private static final int VIEW_TAG_2 = 1280504021;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_take_survey, container, false);
        // Set surveyLayout to be LinearLayout in fragment layout file
        surveyLayout = (LinearLayout) v.findViewById(R.id.take_survey_layout);
        // Set context to be getActivity. This is used repeatedly to create views in code.
        context = getActivity();

        submitSelectionButton = (Button) v.findViewById(R.id.submit_selection_button);
        // method submitSelection to be implemented!!
        submitSelectionButton.setOnClickListener(submitSelectionListener());

        answerViews = new ArrayList<View>();

        /*
         * Querying a ParseObject:
//         * 0. Creating a query to Parse.
//         * 1. Retrieves the data from the Question ParseObject.
//         * 2. Using that data, we create an QuestionObject called survey.
//         * 3. Calling addQuestionSet(), passing survey as an QuestionObject.
//         */
        // Get survey name to that was chosen from SurveyListFragment
        Bundle args = getArguments();
        selectedSurvey = args.getString(SURVEY_ID);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Questions");
        // Filter query to find questions related to survey
        query.whereEqualTo("surveyName", selectedSurvey);

        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> results, ParseException e) {
                if (e == null) {
                    Log.d("Parse Query status", "Parse Query Successful");

                    // Retrieving the Data from the "Questions" ParseObject
                    for (ParseObject object : results) {

                        //String questionID = object.getObjectId();
                        String questionText = object.getString("question");
                        Boolean multi = object.getBoolean("multi");
                        List<String> possibleAnswers = object.getList("possibleAnswers");
                        String creator = object.getString("creator");

                        // Creates QuestionObject "survey" and calls addQuestionSet()
                        Question survey = new Question(questionText, possibleAnswers, multi, creator);
                        addQuestionSet(survey);
                    }
                } else {
                    Log.d(getClass().getSimpleName(), "Error: " + e.getMessage());
                }
            }
        });

        return v;
    }

    /**
     * Adds a question and its set of answers to the layout view
     * @param q the Question class that contains the QA information
     */
    private void addQuestionSet(Question q) {
        // Add question to layout
        TextView question = new TextView(getActivity());
        question.setText(getString(R.string.creator_and_question_placeholder, q.getCreator(), q.getQuestion()));

        surveyLayout.addView(question);

        // Add answers corresponding to question
        View view;
        if (q.isMultiAnswer()) {
        // Create CheckBoxes if true
            view = createCheckBoxGroup(q.getQuestion(), q.getPossibleAnswers());
        } else {
        // else create radiogroup
            view = createRadioGroup(q.getQuestion(), q.getPossibleAnswers());
        }
        surveyLayout.addView(view);
    }


    /**
     * Given a list of answers, creates and returns a group of radio buttons
     * @param answers answers to create radio buttons from
     * @return radiogroup representing collection of answers
     */
    private RadioGroup createRadioGroup(String question, List<String> answers) {
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(LinearLayout.VERTICAL);

        // Loop through answer list and add a radio button for each one.
        for (int i = 0; i < answers.size(); i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(answers.get(i));
            radioButton.setTextColor(Color.BLACK);
            radioGroup.addView(radioButton);

            // 1 = question, 2 = answer#
            radioButton.setTag(VIEW_TAG_1, question);
            radioButton.setTag(VIEW_TAG_2, "A" + String.valueOf(i + 1));
            answerViews.add(radioButton);
        }
        return radioGroup;
    }


    /**
     * Given a list of answers, creates and returns a group of CheckBox views contained
     * within a LinearLayout groupview.
     * @param answers answers to create CheckBoxes from
     * @return LinearLayout containing the collection of answers
     */
    private LinearLayout createCheckBoxGroup(String question, List<String> answers) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Loop through answer list and add a CheckBox to linearLayout for each one.
        for (int i = 0; i < answers.size(); i++) {
            CheckBox checkbox = new CheckBox(context);
            checkbox.setText(answers.get(i));
            checkbox.setTextColor(Color.BLACK);
            linearLayout.addView(checkbox);

            // 1 = question, 2 = answer#
            checkbox.setTag(VIEW_TAG_1, question);
            checkbox.setTag(VIEW_TAG_2, "A" + String.valueOf(i + 1));
            answerViews.add(checkbox);
        }
        return linearLayout;
    }


    // To be implemented!!
    private View.OnClickListener submitSelectionListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Submit:", "Selection Submit Method Called");

                for(View view : answerViews){

                    if((view instanceof CheckBox && ((CheckBox)view).isChecked()) || (view instanceof RadioButton && ((RadioButton)view).isChecked())){
                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Results");
                        query.whereEqualTo("surveyName", selectedSurvey);
                        query.whereEqualTo("question", view.getTag(VIEW_TAG_1).toString());

                        final String answerNum = view.getTag(VIEW_TAG_2).toString();

                        query.findInBackground(new FindCallback<ParseObject>() {
                            @Override
                            public void done(List<ParseObject> results, ParseException e) {
                                if (e == null) {
                                    Log.d("Parse Query status", "Parse Query Successful");
                                    results.get(0).increment(answerNum);
                                    results.get(0).saveInBackground();
                                } else {
                                    Log.d(getClass().getSimpleName(), "Error: " + e.getMessage());
                                }
                            }
                        });
                    }
                }

                Toast.makeText(v.getContext(), "Survey completed!", Toast.LENGTH_SHORT).show();

                // Transition back to the main menu
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        };
    }


}
