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

public class chating extends AppCompatActivity  implements View.OnClickListener{

    String ems;
    Button bt,sendM;
    EditText a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chating);
        getSupportActionBar().setTitle("chats");
        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        bt=(Button)findViewById(R.id.back);
        sendM=(Button)findViewById(R.id.sendmessage);
        a =(EditText)findViewById(R.id.email);
        b =(EditText)findViewById(R.id.message);

        bt.setOnClickListener(this);
        sendM.setOnClickListener(this);










        final TextView t = (TextView)findViewById(R.id.displaychats);
        ContentValues params = new ContentValues();
        params.put("email",ems);

        AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://192.168.43.68/chats.php",params) {
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

                        some = " "+"email  :  "+Aw.get("semail")+"\n"+"\n"+"\n"+"\n"+"  "+"msg  :  "+" "+Aw.get("msg")+"\n"+"\n"+"\n"+"\n"+"  "
                                +" "+"sent to  :  "+" "+Aw.get("remail") ;
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

            Intent intent = new Intent(chating.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);
        }

        if(v.equals(v.equals(sendM))){

            String Remail =a.getText().toString().trim();
            String msge=b.getText().toString().trim();
            boolean st= true;

            if(Remail.equals("")){
                a.setError("receiver email cannot be empty");
                st=false;
            }

            if(msge.equals("")){
                b.setError("please tyoe in a message");
                st= false;
            }

            else if(st == true){

                //send msg...check if the receiver email exist...then send msg


                String type ="reg";
                Backchating backgroundTask = new Backchating(getApplicationContext(),"");
                backgroundTask.execute(type,ems,Remail,msge);

                a.setText("");
                Intent intent = new Intent(chating.this,Homepage.class);
                intent.putExtra("email",ems);
                startActivity(intent);




            }

        }



    }
}
