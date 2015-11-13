package com.project.se137.survey;

import java.util.ArrayList;

/**
 * Represents a single question with multiple answers.
 * Answers that allow multiple choices will be displayed as CheckBoxes
 * Answers that allow only one choice will be displayed as Radio buttons
 */
public class Question {
    // The question
    private String Question;
    // Possible answers to the question
    private ArrayList<String> possibleAnswers;
    //  True -> CheckBox, False -> Radio
    boolean mMultiAnswer;

    public Question(String q, ArrayList<String> a) {
        Question = q;
        possibleAnswers = a;
    }

    public String getQuestion() {
        return Question;
    }

    public ArrayList<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}