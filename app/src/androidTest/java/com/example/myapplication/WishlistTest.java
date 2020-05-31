package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class WishlistTest {


    @Rule
    public ActivityTestRule<Wishlist> activityTestRule = new ActivityTestRule<>(Wishlist.class);



    @Test
    public void msgTEST(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.add).performClick();
                activityTestRule.getActivity().a.setText("cassius123");
                activityTestRule.getActivity().b.setText("wrong pass");
                activityTestRule.getActivity().findViewById(R.id.add).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




    @Test
    public void dummyFunctionWithParams(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().vverifyinput("cassius","surname");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void EXcuteEVERything(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().exEVER();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }





    @Test
    public void takeINPUT(){
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().takinginputtt();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void homeback(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.back).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void stayW(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.add).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




}