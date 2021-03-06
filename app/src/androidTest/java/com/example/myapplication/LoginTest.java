package com.example.myapplication;

import android.os.Bundle;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;

@RunWith(AndroidJUnit4.class)
public class LoginTest {




    @Rule
    public ActivityTestRule<Login> activityTestRule = new ActivityTestRule<>(Login.class);






    @Test
    public void onCreate() {


        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().onCreate(new Bundle());
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }





    }






    @Test
    public void tryLoginAsStudent(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.signin).performClick();
                activityTestRule.getActivity().a.setText("cassius123");
                activityTestRule.getActivity().b.setText("wrong pass");
                activityTestRule.getActivity().findViewById(R.id.signin).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void dummyFunctionWithParams(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().verifyinput("cassius","password");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






    @Test
    public void logingpback(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.signin).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }







}