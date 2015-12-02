package com.project.se137.survey;

import android.app.Activity;
import android.util.Log;

/**
 * Created by danielnguyen on 12/2/15.
 */
public class GlobalVariable extends Activity{

    String loggedInUser;

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        Log.d("setLoggedInUser:", loggedInUser);
    }

}
