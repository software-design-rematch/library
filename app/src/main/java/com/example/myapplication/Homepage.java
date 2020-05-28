package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class Homepage extends AppCompatActivity implements View.OnClickListener {


    String ems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setTitle("LIBRARY");

        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homepagemenu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.profileee:
                Intent intent = new Intent(Homepage.this,Userprofile.class);
                intent.putExtra("email",ems);
                startActivity(intent);
                return true;


            case  R.id.chatsss:
                Intent intent1 = new Intent(Homepage.this,chating.class);
                intent1.putExtra("email",ems);
                startActivity(intent1);
                return true;


            case R.id.wishhh:
                Intent intent2 = new Intent(Homepage.this,Wishlist.class);
                intent2.putExtra("email",ems);
                startActivity(intent2);
                return true;

            case  R.id.addbk:
                Intent intent3 = new Intent(Homepage.this,AddBooks.class);
                intent3.putExtra("email",ems);
                startActivity(intent3);
                return true;

            case R.id.deletebk:
                Intent intent4 = new Intent(Homepage.this,Delete.class);
                intent4.putExtra("email",ems);
                startActivity(intent4);
                return true;


            case R.id.searchbk:
                Intent intent5 = new Intent(Homepage.this,searchbooksss.class);
                intent5.putExtra("email",ems);
                startActivity(intent5);
                return true;

            case R.id.loanbk:
                Intent intent6 = new Intent(Homepage.this,Issuebook.class);
                intent6.putExtra("email",ems);
                startActivity(intent6);
                return  true;

            case  R.id.returnbk:
                Intent intent7 = new Intent(Homepage.this,rreturnbooks.class);
                intent7.putExtra("email",ems);
                startActivity(intent7);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }


    }

    @Override
    public void onClick(View v) {



    }
}
