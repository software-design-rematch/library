package com.example.myapplication;

import android.os.Bundle;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class IssuebookTest {

    @Rule
    public ActivityTestRule<Issuebook> activityTestRule = new ActivityTestRule<>(Issuebook.class);




    @Test
    public void Loanevery() {

        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.borroww).performClick();
                activityTestRule.getActivity().a.setText("cassius123");
                activityTestRule.getActivity().findViewById(R.id.borroww).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    @Test
    public void RETevsery() {

        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.isbn).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }






    @Test
    public void loback() {

        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.back).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }





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
    public void testIaS() {



        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().taIN();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }





    }

    @Test
    public void tadIN() {

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().issueT("cassius");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }




    }

    @Test
    public void isdsueT() {


        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().testIS();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }




    }
}