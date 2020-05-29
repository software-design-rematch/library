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
    public void testVerifyinput(){
        int res = createA.verifyinput("cassius","surname","c@gmail.com","aa","aa","male");
       assertEquals("failed",1,res);

    }

}