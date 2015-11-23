package com.project.se137.survey;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by calvin on 11/23/2015.
 */
public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new MainFragment();
    }

    public void onCreateSurveyClicked(View v){
        Intent createSurveyIntent = new Intent(this, CreateSurveyActivity.class);
        startActivity(createSurveyIntent);
    }

    public void onViewSurveyClicked(View v){
        Intent surveyIntent = new Intent(this, SurveyActivity.class);
        startActivity(surveyIntent);
    }

    public void onViewResultClicked(View v){

    }
}
