package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ratebook extends AppCompatActivity {

    RatingBar rBar;
   String ems,nm;
   Button rt;
    int noofstars;
    float getrating;
   EditText a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratebook);

        getSupportActionBar().setTitle("RATE BOOKS");


        Intent intent =getIntent();
        ems =intent.getStringExtra("email");



        rBar = (RatingBar) findViewById(R.id.ratingBar1);
        rt =(Button)findViewById(R.id.ratee);
        a=(EditText)findViewById(R.id.nameb);


        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIN();

                if(verfy(nm) == true){
                    rttt();
                    //Toast.makeText(getApplicationContext(),"Rating: "+getrating+"/"+noofstars,Toast.LENGTH_SHORT).show();

                    String rtx =getrating+"/"+noofstars;
                    String type ="reg";
                    backratebook backgroundTask = new backratebook(getApplicationContext(),"");
                    backgroundTask.execute(type, ems, nm ,rtx);

                    a.setText("");
                    Intent intent = new Intent(Ratebook.this,Homepage.class);
                    intent.putExtra("email",ems);
                    startActivity(intent);






                }

            }
        });



        BottomNavigationView bottomNavigationView =findViewById(R.id.bottombookrate);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Bswitch(menuItem);
                return false;
            }
        });






    }

    public void getIN(){
        nm =a.getText().toString().trim();

    }

    public  void rttt(){
         noofstars = rBar.getNumStars();
         getrating = rBar.getRating();


    }

    public  boolean verfy(String aa){
        boolean st = true;
        if(aa.equals("")){
            a.setError("type in book name");
            st = false;
        }
        return  st;
    }

    public  boolean Bswitch(MenuItem menuItem){

        switch (menuItem.getItemId()){

            case R.id.homaee:
                Intent intent = new Intent(Ratebook.this,Homepage.class);
                intent.putExtra("email",ems);
                startActivity(intent);
                return true;

            default:
                return  false;

        }


    }



}
