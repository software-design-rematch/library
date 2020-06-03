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
public class searchbooksssTest {

    @Rule
    public ActivityTestRule<searchbooksss> activityTestRule = new ActivityTestRule<>(searchbooksss.class);




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
    public void seTEST(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.sBOOK).performClick();
                activityTestRule.getActivity().bookNAMEAUTHOR.setText("cassius123");
                activityTestRule.getActivity().findViewById(R.id.sBOOK).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void seback(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.back).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void stEVER() {

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().stEVER();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    @Test
    public void takeINN() {



        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().takeINN();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }



    }


    @Test
    public void ttestI() {
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().testI("cassius");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}