package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;

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
    public void Item1(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.wishhh);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




    @Test
    public void Item2(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.deletebk);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void Item3(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.searchbk);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void Item4(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.addbk);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Test
    public void Item5(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.loanbk);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



    @Test
    public void Item6(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.homepagemenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.returnbk);
                activityTestRule.getActivity().onOptionsItemSelected(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }






    @Test
    public void onCreateMenu(){
        try {
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                activityTestRule.getActivity().onCreateOptionsMenu(p.getMenu());
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }





}