package com.project.se137.survey;

import android.app.Activity;
import android.util.Log;

/**
 * Created by danielnguyen on 12/2/15.
 */
public class GlobalVariable extends Activity{

    public static String loggedInUser;

    public static int result;

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(String loggedInUser) {
        GlobalVariable.loggedInUser = loggedInUser;
        Log.d("setLoggedInUser:", loggedInUser);
    }

}
