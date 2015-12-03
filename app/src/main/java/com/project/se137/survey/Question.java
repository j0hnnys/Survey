package com.project.se137.survey;

import java.util.List;

/**
 * Represents a single question with multiple answers and its creator.
 * Answers that allow multiple choices will be displayed as CheckBoxes
 * Answers that allow only one choice will be displayed as Radio buttons
 */
public class Question {
    // The question
    private String mQuestion;
    // Possible answers to the question
    private List<String> mPossibleAnswers;
    //  True -> CheckBox, False -> Radio
    private boolean mMultiAnswer;
    // Creator of the Survey Attribute - for UserManagement
    private String mCreator = GlobalVariable.getLoggedInUser();


    public Question(String question, List<String> answers, boolean multiAnswer, String creator) {
        mQuestion = question;
        mPossibleAnswers = answers;
        mMultiAnswer = multiAnswer;
        mCreator = creator;
    }
    public Question(String question, List<String> answers, boolean multiAnswer) {
        mQuestion = question;
        mPossibleAnswers = answers;
        mMultiAnswer = multiAnswer;
    }



    @Override
    public String toString() {
        return mQuestion + " " + mMultiAnswer + " " + mPossibleAnswers.toString() + " " + mCreator;
    }

    // Getter Setter QuestionID
//    public String getQuestionID() {
//        return mQuestionID;
//    }
//    public void setQuestionID(String questionID) {
//        mQuestionID = questionID;
//    }

    //Getter Setter boolean isMultiAnswer
    public boolean isMultiAnswer() {
        return mMultiAnswer;
    }
    public void setMultiAnswer(boolean multiAnswer) {
        mMultiAnswer = multiAnswer;
    }

    //Getter Setter String Question
    public String getQuestion() {
        return mQuestion;
    }
    public void setQuestion(String question) {
        mQuestion = question;
    }

    //Getter Setter List<String> PossibleAnswers
    public List<String> getPossibleAnswers() {
        return mPossibleAnswers;
    }
    public void setPossibleAnswers(List<String> possibleAnswers) {
        mPossibleAnswers = possibleAnswers;
    }

    //Getter  String Creator
    public String getCreator() {
        return mCreator;
    }
}