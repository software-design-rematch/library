package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    Button ad,deletebook,SBOOK,IBOOK,RBOOK,Upro;
    String ems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setTitle("LIBRARY");
        deletebook=(Button)findViewById(R.id.deletebook);
        ad =(Button)findViewById(R.id.addbook);
        SBOOK=(Button)findViewById(R.id.searchbook);
        IBOOK=(Button)findViewById(R.id.isuebook);
        RBOOK=(Button)findViewById(R.id.returnbook);
        Upro=(Button)findViewById(R.id.userprofile);
        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        ad.setOnClickListener(this);
        deletebook.setOnClickListener(this);
        SBOOK.setOnClickListener(this);
        IBOOK.setOnClickListener(this);
        RBOOK.setOnClickListener(this);
        Upro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {




        if(v.equals(RBOOK)){
            Intent intent = new Intent(Homepage.this,rreturnbooks.class);
            intent.putExtra("email",ems);
            startActivity(intent);


        }


        if(v.equals(Upro)){
            Intent intent = new Intent(Homepage.this,Userprofile.class);
            intent.putExtra("email",ems);
            startActivity(intent);


        }




        if(v.equals(ad)){
            Intent intent = new Intent(Homepage.this,AddBooks.class);
            intent.putExtra("email",ems);
            startActivity(intent);



        }

        if(v.equals(deletebook)){
            Intent intent = new Intent(Homepage.this,Delete.class);
            intent.putExtra("email",ems);
            startActivity(intent);


        }


        if(v.equals(SBOOK)){

            Intent intent = new Intent(Homepage.this,searchbooksss.class);
            intent.putExtra("email",ems);
            startActivity(intent);


        }


        if(v.equals(IBOOK)){
            Intent intent = new Intent(Homepage.this,Issuebook.class);
            intent.putExtra("email",ems);
            startActivity(intent);


        }





    }
}
