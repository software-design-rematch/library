package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class rreturnbooks extends AppCompatActivity implements View.OnClickListener {

    String ems;
    Button retB,bk;
    EditText a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rreturnbooks);
        getSupportActionBar().setTitle("RETURN BOOKS");


        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        bk=(Button)findViewById(R.id.back);
        retB=(Button)findViewById(R.id.returnbook);
        a=(EditText)findViewById(R.id.typeISBN);

        bk.setOnClickListener(this);
        retB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.equals(bk)){
            Intent intent = new Intent(rreturnbooks.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);

        }


        if(v.equals(retB)){


            String isbnnn=a.getText().toString().trim();

            boolean state = true;

            if(isbnnn.equals("")){
                a.setError("please type in book code");
                state = false;
            }

            else if(state == true) {


                String  mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


                String type ="reg";
                Backreturnbook backgroundTask = new Backreturnbook(getApplicationContext(),"");
                backgroundTask.execute(type, ems, isbnnn , mydate);

                a.setText("");
                Intent intent = new Intent(rreturnbooks.this,Homepage.class);
                intent.putExtra("email",ems);
                startActivity(intent);


                //check if book exist and was taken by the user who wants to return it then it from issue book database;

            }





            }



    }
}
