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
public class rreturnbooksTest {


    @Rule
    public ActivityTestRule<rreturnbooks> activityTestRule = new ActivityTestRule<>(rreturnbooks.class);



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
    public void RETevery() {

        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.returnbook).performClick();
                activityTestRule.getActivity().a.setText("cassius123");
                activityTestRule.getActivity().findViewById(R.id.returnbook).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    @Test
    public void takeINNN() {



        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().testRE("cassius");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }





    }


    @Test
    public void testRE() {




        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().takeINNN();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }



    @Test
    public  void exT(){

        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().RETevery();
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






}