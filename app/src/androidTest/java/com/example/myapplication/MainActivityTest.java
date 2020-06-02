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
public class MainActivityTest {
    @Rule
    public ActivityTestRule<searchbooksss> activityTestRule = new ActivityTestRule<>(searchbooksss.class);



    @Test
    public void onCreate() {


            try{
                runOnUiThread(() -> {
                    activityTestRule.getActivity().onCreate(new Bundle());
                });
            } catch (Throwable throwable) {
                throwable.printStackTrace();}
    }
}