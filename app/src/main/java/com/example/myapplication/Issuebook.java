package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Issuebook extends AppCompatActivity implements View.OnClickListener {
    EditText a;
    String ems,isbnnn;
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


            taIN();


            if(issueT(isbnnn) == true){


                testIS();

                //check if book exist and is free then add it to issue book database;


            }










                        }




    }






    public void testIS(){


        String  mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        String type ="reg";
        Backloanbook backgroundTask = new Backloanbook(getApplicationContext(),"");
        backgroundTask.execute(type, ems, isbnnn , "taken",mydate);

        a.setText("");
        Intent intent = new Intent(Issuebook.this,Homepage.class);
        intent.putExtra("email",ems);
        startActivity(intent);







    }






    public  void taIN(){
        isbnnn=a.getText().toString().trim();
    }




    public  boolean issueT(String aa){


        boolean state = true;

        if(aa.equals("")){
            a.setError("please type in book code");
            state = false;
        }

        return  state;
    }







}
