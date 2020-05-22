package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Userprofile extends AppCompatActivity implements View.OnClickListener{

    String ems;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        getSupportActionBar().setTitle("PROFILE");

        Intent intent =getIntent();
        ems =intent.getStringExtra("email");

        bt=(Button)findViewById(R.id.back);
        bt.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {


        if(v.equals(bt)){

            Intent intent = new Intent(Userprofile.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);




        }



    }
}
