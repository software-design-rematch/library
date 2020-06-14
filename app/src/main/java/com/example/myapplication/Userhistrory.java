package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Userhistrory extends AppCompatActivity implements View.OnClickListener {

    Button bt;

    String ems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhistrory);
        getSupportActionBar().setTitle("HISTORY");

        Intent intent =getIntent();
        ems =intent.getStringExtra("email");

        bt=(Button)findViewById(R.id.back);


        bt.setOnClickListener(this);


        final TextView t = (TextView)findViewById(R.id.displayinfo);
        ContentValues params = new ContentValues();
        params.put("email",ems);

        AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://10.100.15.37/userhistory.php",params) {
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

                        some = " "+"email  :  "+" "+Aw.get("email")+" "+"\n"+"\n"+"\n"+"\n"+"book code  :  "+Aw.get("isbn")+"\n"+"\n"+"\n"+"\n"+"  "+"time  :  "+" "+Aw.get("returntime");
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

    @Override
    public void onClick(View v) {
        if(v.equals(bt)){
            Intent intent = new Intent(Userhistrory.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);

        }


    }
}
