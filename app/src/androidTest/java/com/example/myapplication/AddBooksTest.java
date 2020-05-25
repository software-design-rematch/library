package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class AddBooksTest {

    @Rule
    public ActivityTestRule<Homepage> activityTestRule = new ActivityTestRule<>(Homepage.class);





    @Test
    public void bgeddbook(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.dp).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void bgedaddbook(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.nextt).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }









}