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
    public ActivityTestRule<AddBooks> activityTestRule = new ActivityTestRule<>(AddBooks.class);



    @Test
    public void takeINS() {

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().takeINS();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    @Test
    public void verINs() {

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().verINs("addad","newbook","anotheboo");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    @Test
    public void exxEVER() {

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().exxEVER();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}