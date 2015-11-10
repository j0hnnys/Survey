package com.project.se137.survey;

import java.util.ArrayList;

/**
 * Created by Johnny on 11/5/15.
 */
public class Question {
    private String Question;
    private ArrayList<String> possibleAnswers;

    //  True -> CheckBox, False -> Radio
    boolean mMultiAnswer;

    public Question(String q, ArrayLis<String> a) {
        Question = q;
        possibleAnswers = a;
    }
}
