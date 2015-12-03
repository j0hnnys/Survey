package com.project.se137.survey;

import java.util.ArrayList;

/**
 * Stores the results of a completed survey.
 */
public class Result {
    String mSurvey;
    String mQuestion;
    Boolean[] mAnswer;

    // Constructor. Takes in survey name/id, question, and seletced answer
    public Result(String s, String q, Boolean[] a){
        mSurvey = s;
        mQuestion = q;
        mAnswer = a;
    }

    public void setQuestion(String q) {
        mQuestion = q;
    }

    public Boolean[] getAnswers() {
        return mAnswer;
    }

    public void setAnswers(Boolean[] a) {
        mAnswer = a;
    }

    public String getQuestion() {
        return mQuestion;
    }
}