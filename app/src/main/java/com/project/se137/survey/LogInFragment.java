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
                boolean valid = false;

                username = usernameEditText.getText().toString();

                password = passwordEditText.getText().toString();

                // INPUT VALIDATION
                if ( username.length() == 0 ) { usernameEditText.setError("Username is required!");
                } else if ( username.length() < 4 ) { usernameEditText.setError("min 4 characters"); }

                if ( password.length() == 0 ) { passwordEditText.setError("Password is required!");
                } else if ( password.length() < 4 ) { passwordEditText.setError("min 4 characters"); }

                //Checks in Hashmap, whether username is already used and creates Toasts.
                if (username.length() >= 4 && password.length() >= 4) {
                    if (accounts.containsKey(username)) {
                        usernameEditText.setError("Try another");
                        Toast.makeText(v.getContext(), "Username is already in use. Please, choose another Username", Toast.LENGTH_SHORT).show();
                    } else if ( username == password ) {
                        Toast.makeText(v.getContext(), "Username and Password must be different", Toast.LENGTH_SHORT).show();
                    } else {
                        valid = true;
                    }
                } else if (username.length() == 0 && password.length() == 0) {
                    Toast.makeText(v.getContext(), "You need to input both Username and Password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(), "Both Username and Password must be longer than 3", Toast.LENGTH_SHORT).show();
                }

                if (valid) {
                    accounts.put(username, password);
                    usernameEditText.setText(""); // clears text
                    passwordEditText.setText("");
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
