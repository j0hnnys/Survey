package com.project.se137.survey;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by danielnguyen on 11/23/15.
 */

//It is important to import android.support.v4.app.Fragment and not android.app.Fragment
public class LogInFragment extends Fragment {

    EditText usernameEditText;
    EditText passwordEditText;

    HashMap<String, String>accounts = new HashMap<String, String>();

    Button logInButton;
    Button createAccountButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_log_in_screen, container, false);

        usernameEditText = (EditText) v.findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) v.findViewById(R.id.password_edit_text);

        logInButton = (Button) v.findViewById(R.id.log_in_button);
        createAccountButton = (Button) v.findViewById(R.id.create_account_button);

        //createAccountButton adds credentials to ArrayList
        createAccountButton.setOnClickListener(createAccountListener());

        return v;
    }

    private View.OnClickListener createAccountListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username;
                String password;

                username = usernameEditText.getText().toString();

                password = passwordEditText.getText().toString();

                //Checks in Hashmap, whether username is already used and creates Toasts.
                if (accounts.containsKey(username)) {
                    Toast.makeText(v.getContext(), "Username is already in use. Please, choose another Username", Toast.LENGTH_SHORT).show();
                } else {
                    accounts.put(username, password);
                    Toast.makeText(v.getContext(), "Account was created successfully!", Toast.LENGTH_SHORT).show();
                }

                /* TESTING
                unamePass.put("user1", "pass1");
                unamePass.put("user2", "pass2");
                unamePass.put("user3", "pass3");
                unamePass.put("user4", "pass4");
                if(accounts.get("user1")!=null)
                {
                    String password= accounts.get("user1");
                }Log.d("Hello", "This is a test");
                */

            }
        };
    }
}
