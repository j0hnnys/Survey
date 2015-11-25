package com.project.se137.survey;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single question with multiple answers and its creator.
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
    // Creator of the Survey Attribute - for UserManagement
    private String mCreator;

    public Question(String q, List<String> a, boolean multiAnswer, String creator) {
        Question = q;
        possibleAnswers = a;
        mMultiAnswer = multiAnswer;
        mCreator = creator;
    }

    //PARSE
    @Override
    public String toString() {
        return Question + " " + mMultiAnswer + " " + possibleAnswers.toString() + " " + mCreator;
    }

    //Getter Setter boolean isMultiAnswer
    public boolean isMultiAnswer() {
        return mMultiAnswer;
    }
    public void setMultiAnswer(boolean multiAnswer) {
        mMultiAnswer = multiAnswer;
    }

    //Getter Setter String Question
    public String getQuestion() {
        return Question;
    }
    public void setQuestion(String question) {
        Question = question;
    }

    //Getter Setter List<String> PossibleAnswers
    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    //Getter and Setter String Creator
    public String getCreator() {
        return mCreator;
    }
    public void setCreator(String creator) {
        mCreator = creator;
    }

}