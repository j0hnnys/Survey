package com.project.se137.survey.CreateSurveyScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.project.se137.survey.Question;
import com.project.se137.survey.R;

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
    Button completeButton;

    ArrayList<Question> survey;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflates. Inflates fragment_create_survey
        View v = inflater.inflate(R.layout.fragment_create_survey, container, false);

        // Declare initial variables to  the views in the layout file
        questionEditText = (EditText) v.findViewById(R.id.question_edit_text);
        answerEditText1 = (EditText) v.findViewById(R.id.answer1_edit_text);
        answerEditText2 = (EditText) v.findViewById(R.id.answer2_edit_text);
        answerEditText3 = (EditText) v.findViewById(R.id.answer3_edit_text);
        answerEditText4 = (EditText) v.findViewById(R.id.answer4_edit_text);
        isMultiCheckBox = (CheckBox) v.findViewById(R.id.multi_question_checkbox);
        addButton = (Button) v.findViewById(R.id.add_button);
        completeButton = (Button) v.findViewById(R.id.complete_button);

        survey = new ArrayList<>();

        addButton.setOnClickListener(addToSurveyListener());

        return v;
    }

    private View.OnClickListener addToSurveyListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q;
                ArrayList<String> answers;
                boolean multiAnswer;
                // Should implement a creator attribute for survey for UserManagement
                String creator = "";

                // Obtain question and clear text
                q = questionEditText.getText().toString();
                questionEditText.setText(""); // clears text

                // Obtain answers;
                answers = getAnswers(v);

                // Check if it is a multi-answer question
                multiAnswer = isMultiCheckBox.isChecked();

                // Create question object and add to survey
                Question question = new Question(q, answers, multiAnswer, creator);
                survey.add(question);

                Toast.makeText(v.getContext(), "Question added to survey!", Toast.LENGTH_SHORT).show();
            }
        };
    }

    /**
     * Obtains all answers in the answer EditText fields and clears all of them.
     * @param v the view where you want to obtain the answers from
     * @return an ArrayList of answer strings obtained from the view
     */
    private ArrayList<String> getAnswers(View v) {
        ArrayList<String> answers = new ArrayList<>();

        // Checks if field isn't empty, if it isn't then add the answer
        // to the ArrayList that is to be returned and clear the edittext field

        if (!answerEditText1.getText().toString().isEmpty()) {
            answers.add(answerEditText1.getText().toString());
            answerEditText1.setText("");
        }

        if (!answerEditText2.getText().toString().isEmpty()) {
            answers.add(answerEditText2.getText().toString());
            answerEditText2.setText("");
        }

        if (!answerEditText3.getText().toString().isEmpty()) {
            answers.add(answerEditText3.getText().toString());
            answerEditText3.setText("");
        }

        if (!answerEditText4.getText().toString().isEmpty()) {
            answers.add(answerEditText4.getText().toString());
            answerEditText4.setText("");
        }

        return answers;
    }
}
