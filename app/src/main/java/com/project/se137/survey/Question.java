package com.project.se137.survey;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single question with multiple answers.
 * Answers that allow multiple choices will be displayed as CheckBoxes
 * Answers that allow only one choice will be displayed as Radio buttons
 */
public class Question {
    // The question
    private String Question;
    // Possible answers to the question
    private List<String> possibleAnswers;
    //  True -> CheckBox, False -> Radio
    private boolean mMultiAnswer;

<<<<<<< HEAD
    public Question(String q, Boolean m,  List<String> a) {
        Question = q;
        possibleAnswers = a;
        mMultiAnswer = m;
=======
    public Question(String q, ArrayList<String> a, boolean multiAnswer) {
        Question = q;
        possibleAnswers = a;
        mMultiAnswer = multiAnswer;
    }

    public boolean isMultiAnswer() {
        return mMultiAnswer;
>>>>>>> origin/master
    }

    public String getQuestion() {
        return Question;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    @Override
    public String toString() {
        return Question + " " + mMultiAnswer + " " + possibleAnswers.toString();
    }
}