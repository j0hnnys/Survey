package com.project.se137.survey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Johnny on 11/16/15.
 */
public class CreateSurveyFragment extends Fragment {

    EditText questionEditText;
    EditText answerEditText1;
    EditText answerEditText2;
    EditText answerEditText3;
    EditText answerEditText4;
    CheckBox isMultiCheckBox;
    Button addButton;
    Button createButton;

    ArrayList<Question> questions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflates. Inflates fragment_create_survey
        View v = inflater.inflate(R.layout.fragment_create_survey, container, false);

        // Declare initial variables to  the views in the layout file
        questionEditText = (EditText) v.findViewById(R.id.question_edit_text);
        isMultiCheckBox = (CheckBox) v.findViewById(R.id.multi_question_checkbox);
        addButton = (Button) v.findViewById(R.id.add_button);
        createButton = (Button) v.findViewById(R.id.create_button);
        answerEditText1 = (EditText) v.findViewById(R.id.answer1_edit_text);
        answerEditText2 = (EditText) v.findViewById(R.id.answer2_edit_text);
        answerEditText3 = (EditText) v.findViewById(R.id.answer3_edit_text);
        answerEditText4 = (EditText) v.findViewById(R.id.answer4_edit_text);

        addButton.setOnClickListener(addButtonListener());
        return v;
    }

    private View.OnClickListener addButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question;
                ArrayList<String> answers;

                // Obtain question and clear text
                question = questionEditText.getText().toString();
                // Obtain answers using getAnswers() function
                answers = getAnswers();
                // Create new Question object from the collected question string and answers
                Question q = new Question(question, answers);

                questions.add(q);
            }
        };
    }

    /**
     * Clears the question and answers text fields
     */
    private void clearScreen() {
        questionEditText.setText("");
        answerEditText1.setText("");
        answerEditText2.setText("");
        answerEditText3.setText("");
        answerEditText4.setText("");
    }
}
