package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Issuebook extends AppCompatActivity implements View.OnClickListener {
    EditText a;
    String ems;
    Button isBk,bk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuebook);
        getSupportActionBar().setTitle("ISSUE BOOKS");

        isBk=(Button)findViewById(R.id.borroww);
        bk=(Button)findViewById(R.id.back);
        a =(EditText)findViewById(R.id.typeISBN);
        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        bk.setOnClickListener(this);
        isBk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.equals(bk)){
            Intent intent = new Intent(Issuebook.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);

        }


        if(v.equals(isBk)){

            String isbnnn=a.getText().toString().trim();

            boolean state = true;

            if(isbnnn.equals("")){
                a.setError("please type in book code");
                state = false;
            }

            else if(state == true){


                //check if book exist and is free then add it to issue book database;







            }










                        }




    }
}
