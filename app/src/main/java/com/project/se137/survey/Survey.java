package com.project.se137.survey;

import java.util.ArrayList;

/**
 * Created by Johnny on 11/9/15.
 */
public class Survey {
    String mName;
    ArrayList<Question> mQuestions;

    public Survey() {

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        mQuestions = questions;
    }
}
