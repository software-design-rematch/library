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
    public ActivityTestRule<Userprofile> activityTestRule = new ActivityTestRule<>(Userprofile.class);


    @Test
    public void logingpback(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.back).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void logingpbgack(){
        try {
            runOnUiThread(() -> {
                activityTestRule.getActivity().findViewById(R.id.sendmessage).performClick();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}