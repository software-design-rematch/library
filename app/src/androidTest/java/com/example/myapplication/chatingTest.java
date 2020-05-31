package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class chatingTest {

    @Rule
    public ActivityTestRule<chating> activityTestRule = new ActivityTestRule<>(chating.class);



    @Test
    public void sendTESTmsgEMPTY(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.sendmessage).performClick();
                activityTestRule.getActivity().aa.setText("cassius123");
                activityTestRule.getActivity().ba.setText("wrong pass");
                activityTestRule.getActivity().findViewById(R.id.sendmessage).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void EeMPTY(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.back).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




    @Test
    public void dummyFunctionWithParams(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().vverifier("cassius","msg");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void EXEVERything(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().exEVERYTHING();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void handleMESSAGE(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().handlemsg();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void Einput(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().Tinput();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }








}