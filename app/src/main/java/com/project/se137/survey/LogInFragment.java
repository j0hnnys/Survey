package com.project.se137.survey;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by danielnguyen on 11/23/15.
 */

//It is important to import android.support.v4.app.Fragment and not android.app.Fragment
public class LogInFragment extends Fragment {

    EditText usernameEditText;
    EditText passwordEditText;

    //ArrayList<User> User;
    Button logInButton;
    Button createUserButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_log_in_screen, container, false);

        usernameEditText = (EditText) v.findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) v.findViewById(R.id.password_edit_text);

        logInButton = (Button) v.findViewById(R.id.log_in_button);
        createUserButton = (Button) v.findViewById(R.id.create_user_button);

        return v;
    }


}
