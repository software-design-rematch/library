package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        //bt=(Button)findViewById(R.id.back);
        //bt.setOnClickListener(this);



        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomprofile);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Bswitch(menuItem);
                return false;
            }
        });

        //display data
        exEverything();

    }





    public  void  exEverything(){

        final TextView t = (TextView)findViewById(R.id.displayinfo);

        ContentValues params = new ContentValues();
        params.put("email",ems);

        AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://192.168.43.68/userinfo.php",params) {
            @Override
            protected void onPostExecute(String output) {

                JSONArray T = null;
                try{
                    T = new JSONArray(output);
                    int a =T.length();
                    String Arr1[] = new String[a];


                    for(int i =0;i<T.length();i++){
                        String some="";
                        JSONObject Aw =(JSONObject)T.get(i);

                        some = " "+"first names  :  "+Aw.get("name")+"\n"+"\n"+"\n"+"\n"+"  "+"surname  :  "+" "+Aw.get("surname")+"\n"+"\n"+"\n"+"\n"+"  "
                                +" "+"email  :  "+" "+Aw.get("email") +"\n"+"\n"+"\n"+"\n"+"  "+"gender  : "+Aw.get("gender")+"\n"+"\n"+"\n"+"\n";
                        Arr1[i]=some;
                    }

                    String fn="";

                    for(int i=0;i<Arr1.length;i++){

                        fn = fn + Arr1[i]+"\n";
                    }

                    t.setText(fn);

                }
                catch(JSONException k){k.printStackTrace();}



            }
        };
        asyncHTTPPost.execute();

    }



    public  boolean Bswitch(MenuItem menuItem){

        switch (menuItem.getItemId()){

            case R.id.homaee:
                Intent intent = new Intent(Userprofile.this,Homepage.class);
                intent.putExtra("email",ems);
                startActivity(intent);
                return true;

            default:
                return  false;

        }


    }

    @Override
    public void onClick(View v) {

    }
}
