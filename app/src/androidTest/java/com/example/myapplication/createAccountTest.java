package com.example.myapplication;

import android.os.Bundle;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class createAccountTest {

    private createAccount createA;


    @Rule
    public ActivityTestRule<createAccount> activityTestRule = new ActivityTestRule<>(createAccount.class);


    @Before
    public void setup(){
        createA = new createAccount();

    }

    @Test
    public void onCreate() {
        try {
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
                activityTestRule.getActivity().takeinput();
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void testVerifyinput(){
        boolean res = createA.verifyinput("cassius","surname","c@gmail.com","aa","aa","male");
        assertEquals("failed",true,res);

    }

}