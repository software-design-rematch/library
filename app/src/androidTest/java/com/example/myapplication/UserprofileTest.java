package com.example.myapplication;

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
public class UserprofileTest {

    @Rule
    public ActivityTestRule<Userprofile> activityTestRule = new ActivityTestRule<>(Userprofile.class);



    public void BItem(){
        try{
            runOnUiThread(() -> {
                PopupMenu p = new PopupMenu(activityTestRule.getActivity(), null);
                p.getMenuInflater().inflate(R.menu.promenu, p.getMenu());
                MenuItem dummyMenuItem1 = p.getMenu().findItem(R.id.homee);
                activityTestRule.getActivity().Bswitch(dummyMenuItem1);
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }



}