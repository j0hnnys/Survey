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
    EditText answerEditText;
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


        return v;
    }

    private View.OnClickListener addToSurvey() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question;
                ArrayList<String> answers = new ArrayList<>();

                // Obtain question and clear text
                question = questionEditText.getText().toString();
                questionEditText.setText(""); // clears text


            }
        };
    }
}
