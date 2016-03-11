package com.project.se137.survey;

/**
 * Created by danielnguyen on 11/25/15.
 */
public class Account {

    private String mUsername;

    private String mPassword;

    public Account(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    //PARSE
    @Override
    public String toString() {
        return mUsername + " " + mPassword;
    }

    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }
    public void setPassword(String password) {
        mPassword = password;
    }
}
