package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    Button ad,deletebook;
    String ems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setTitle("LIBRARY");
        deletebook=(Button)findViewById(R.id.deletebook);
        ad =(Button)findViewById(R.id.addbook);

        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        ad.setOnClickListener(this);
        deletebook.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {





        if(v.equals(ad)){
            Intent intent = new Intent(Homepage.this,AddBooks.class);
            intent.putExtra("email",ems);
            startActivity(intent);



        }

        if(v.equals(deletebook)){
            Intent intent = new Intent(Homepage.this,Delete.class);
            //intent.putExtra("email",ems);
            startActivity(intent);


        }







    }
}
