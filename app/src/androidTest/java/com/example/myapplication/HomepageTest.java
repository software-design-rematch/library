package com.example.myapplication;

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
                activityTestRule.getActivity().findViewById(R.id.addbook).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void geletebookssss(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.deletebook).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void justrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.searchbook).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void justtrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.isuebook).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




  /*  @Test
    public void justttrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.returnbook).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

*/

    @Test
    public void jjustrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.userprofile).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




    @Test
    public void ajustrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.userhistroy).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }







    @Test
    public void jutrunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.userchat).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






    @Test
    public void jusunavoid(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.userwishlist).performClick();

            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






}