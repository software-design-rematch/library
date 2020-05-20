package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class searchbooksss extends AppCompatActivity implements View.OnClickListener{

    String ems;
    Button seT,baT;
    TextView inforBOOKS;
    EditText bookNAMEAUTHOR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbooksss);
        getSupportActionBar().setTitle("SEARCH BOOKS");


        Intent intent =getIntent();
        ems =intent.getStringExtra("email");

        seT =(Button)findViewById(R.id.sBOOK);
        baT=(Button)findViewById(R.id.back);
        inforBOOKS=(TextView) findViewById(R.id.displayinfo);
        bookNAMEAUTHOR=(EditText)findViewById(R.id.booknameorauthor);

        seT.setOnClickListener(this);
        baT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {



        if(v.equals(baT)){

            Intent intent = new Intent(searchbooksss.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);
        }


        if(v.equals(seT))
        {

            String nora = bookNAMEAUTHOR.getText().toString().trim();
            int tstng = 1;

            if(nora.equals("")){
                bookNAMEAUTHOR.setError("book name or author ca not be empty");
                tstng = 0;
                               }

            else if(tstng==1){

                        //do search

                             }




        }


    }
}
