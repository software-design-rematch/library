package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class createAccountTest {

    @Rule
    public ActivityTestRule<createAccount> activityTestRule = new ActivityTestRule<>(createAccount.class);

    @Test
    public void gedaddbook(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.loginini).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void generatedUI(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.createA).performClick();
                activityTestRule.getActivity().a.setText("cassius123");
                activityTestRule.getActivity().b.setText("thangza");
                activityTestRule.getActivity().c.setText("cassius@gmail.com");
                activityTestRule.getActivity().d.setText("matsea");
                activityTestRule.getActivity().e.setText("matsea");
                activityTestRule.getActivity().findViewById(R.id.createA).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






}