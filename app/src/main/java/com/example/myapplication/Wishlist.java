package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Wishlist extends AppCompatActivity implements View.OnClickListener {



    Button bt,ad;
    EditText b,a;
    String ems,w,ww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        getSupportActionBar().setTitle("WISHLIST");

        Intent intent =getIntent();
        ems =intent.getStringExtra("email");

        bt =(Button)findViewById(R.id.back);
        ad=(Button)findViewById(R.id.add);
        a =(EditText)findViewById(R.id.addwish);
        b =(EditText)findViewById(R.id.datetime);

        bt.setOnClickListener(this);
        ad.setOnClickListener(this);




        exEVER();
    }

    @Override
    public void onClick(View v) {


        if(v.equals(bt)){
            Intent intent = new Intent(Wishlist.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);

        }
        if(v.equals(ad)){



            takinginputtt();


            if(vverifyinput(w,ww)==true){



                String type = "reg";
                Backwish backgroundTask = new Backwish(getApplicationContext(),"");

                backgroundTask.execute(type,ems,w,ww);


                Intent intent = new Intent(Wishlist.this,Homepage.class);
                intent.putExtra("email",ems);
                startActivity(intent);






            }




        }


    }





    public void exEVER(){




        final TextView t = (TextView)findViewById(R.id.displayinfo);
        ContentValues params = new ContentValues();
        params.put("email",ems);

        AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://10.100.15.37/wish.php",params) {
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

                        some = "wish           :  "+Aw.get("wish")+"\n"+"\n"+"date/time  :  "+" "+Aw.get("time")+"\n"+"\n"+"\n"+"\n";
                        Arr1[i]=some;
                    }

                    String fn="";

                    for(int i=Arr1.length-1;i>=0;i--){

                        fn = fn + Arr1[i]+"\n";
                    }

                    t.setText(fn);

                }
                catch(JSONException k){k.printStackTrace();}



            }
        };
        asyncHTTPPost.execute();



    }


   public  boolean vverifyinput(String aa,String bb){



        boolean st=true;
        if(aa.equals("")){
            a.setError("please fill in here");
            st=false;
        }

        if(bb.equals("")){
            b.setError("time and date can not be empty");
            st = false;
        }

        return st;

    }



    public void takinginputtt(){


        w =a.getText().toString().trim();
        ww =b.getText().toString().trim();

    }

}
