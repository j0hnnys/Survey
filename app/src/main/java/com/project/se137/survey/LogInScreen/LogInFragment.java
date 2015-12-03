package com.project.se137.survey.LogInScreen;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.project.se137.survey.GlobalVariable;
import com.project.se137.survey.MainStartScreen.MainActivity;
import com.project.se137.survey.R;

/**
 * Created by danielnguyen on 11/23/15.
 */

//It is important to import android.support.v4.app.Fragment and not android.app.Fragment
public class LogInFragment extends Fragment {

    EditText usernameEditText;
    EditText passwordEditText;
    EditText passwordRepeatEditText;

    Button logInButton;
    Button createAccountButton;

    CheckBox showPasswordCheckBox;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate a view using layout inflater to inflate the fragment_survey_template.xml file
        View v = inflater.inflate(R.layout.fragment_log_in_screen, container, false);

        usernameEditText = (EditText) v.findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) v.findViewById(R.id.password_edit_text);
        passwordRepeatEditText = (EditText) v.findViewById(R.id.password_repeat_edit_text);

        logInButton = (Button) v.findViewById(R.id.log_in_button);
        createAccountButton = (Button) v.findViewById(R.id.create_account_button);
        showPasswordCheckBox = (CheckBox) v.findViewById(R.id.show_password_checkbox);

        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                passwordRepeatEditText.setTransformationMethod(null);
                passwordEditText.setTransformationMethod(null);

                if (!isChecked) {
                    passwordRepeatEditText.setTransformationMethod(new PasswordTransformationMethod());
                    passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        //createAccountButton adds credentials to ArrayList
        createAccountButton.setOnClickListener(createAccountListener());
        logInButton.setOnClickListener(logInListener());


        return v;
    }


    private View.OnClickListener logInListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String passwordRepeat = passwordRepeatEditText.getText().toString();

                if (validated(username, password, passwordRepeat)) {
                    logIn(username, password);

                    // Goes to main screen if login is successful
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };
    }



    private View.OnClickListener createAccountListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String passwordRepeat = passwordRepeatEditText.getText().toString();

                if (validated(username, password, passwordRepeat)) {
                    createAccount(username, password);
                }
            }
        };
    }

    private void logIn(String u, String p) {

        final GlobalVariable loggedInUser = new GlobalVariable();

        final String username = u;
        final String password = p;
        // Parse
        ParseQuery<ParseObject> logIn = ParseQuery.getQuery("User");
        logIn.whereEqualTo("username", username);
        // Get only first one
        logIn.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {

                if (object == null) {
                    Log.d("Parse", "The logIn request failed.");
                    Toast.makeText(getContext(), "Login failed! Username not found", Toast.LENGTH_SHORT).show();

                } else {
                    String rightPassword = object.getString("password");

                    if (password.equals(rightPassword)) {
                        //Showing a message
                        Toast.makeText(getContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                        // Saving the username to a global variable
                        loggedInUser.setLoggedInUser(username);

                        //Intent intent = new Intent(getActivity(), MainActivity.class);
                        //startActivity(intent);
                        Log.d("Parse", "Retrieved the object.");

                    } else {
                        Log.d("LogIn", "LogIn failed");
                        Toast.makeText(getContext(), "Login failed! Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void createAccount(String u, String p) {

        final String username = u;
        final String password = p;

        ParseQuery<ParseObject> logIn = ParseQuery.getQuery("User");
        logIn.whereEqualTo("username", username);
        logIn.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject objects, ParseException e) {
                if (objects == null) {

                    ParseObject account = new ParseObject("User");
                    account.put("username", username);
                    account.put("password", password);
                    account.saveInBackground();

                } else {
                    Toast.makeText(getContext(), "Username is already in use. Please, choose another Username", Toast.LENGTH_SHORT).show();
                    usernameEditText.setError("Try another");
                }
            }
        });
    }

    private boolean validated(String username, String password, String passwordRepeat) {

        if (username.length() == 0) {
            usernameEditText.setError("Username is required!");
        } else if (username.length() < 4) {
            usernameEditText.setError("min 4 characters");
        }

        if (password.length() == 0) {
            passwordEditText.setError("Password is required!");
        } else if (password.length() < 4) {
            passwordEditText.setError("min 4 characters");
        }

        if (username.length() == 0 && password.length() == 0) {
            Toast.makeText(getContext(), "You need to input both Username and Password", Toast.LENGTH_SHORT).show();
        } else if (username.length() == 0 || password.length() == 0) {

            if (username.length() == 0) {
                usernameEditText.setError("Username is required!");
            }

            if (password.length() == 0) {
                passwordEditText.setError("Password is required!");
            }

        } else if (username.length() < 4 || password.length() < 4) {
            Toast.makeText(getContext(), "Both Username and Password must be longer than 3", Toast.LENGTH_SHORT).show();
            usernameEditText.setError("min 4 characters");

        } else if (username.equals(password)) {
            Toast.makeText(getContext(), "Username and Password must be different", Toast.LENGTH_SHORT).show();

        } else if (!password.equals(passwordRepeat)) {
            passwordRepeatEditText.setError("Does not match");
            passwordRepeatEditText.setTransformationMethod(null);
            Toast.makeText(getContext(), "Password and PasswordRepeat must match", Toast.LENGTH_SHORT).show();
        } else {

            return true;

        }

        return false;
    }
}
