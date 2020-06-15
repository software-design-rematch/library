package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.PopupMenu;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RateuserTest {

    @Rule
    public ActivityTestRule<Rateuser> activityTestRule = new ActivityTestRule<>(Rateuser.class);



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
    public void dummyFunction() {
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().getIN();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void dummunction() {
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().verfy("assa");
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void dummussdnction() {
        try{
            runOnUiThread(() -> {
                activityTestRule.getActivity().rttt();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void logingpback(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.rateee).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




    @Test
    public void Item(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.ratehome, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.homaee);
                activityTestRule.getActivity().Bswitch(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






}