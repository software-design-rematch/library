package com.example.myapplication;

import android.widget.Button;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class HomepageTest {

    @Rule
    public ActivityTestRule<Homepage> activityTestRule = new ActivityTestRule<>(Homepage.class);

    @Test
    public void gedaddbook(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.profileee).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void geletebookssss(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.chatsss).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void justrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.wishhh).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void justyrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.booksss).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void justrunavoikd(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.addbk).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }





    //////


    @Test
    public void justjrunavoikd(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.deletebk).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }





    @Test
    public void justjruknavoikd(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.searchbk).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }





}