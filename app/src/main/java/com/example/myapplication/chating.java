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

    String ems,Remail,msge;
    Button bt,sendM;
    EditText aa,ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chating);
        getSupportActionBar().setTitle("chats");
        Intent intent =getIntent();
        ems =intent.getStringExtra("email");


        bt=(Button)findViewById(R.id.back);
        sendM=(Button)findViewById(R.id.sendmessage);
        aa =(EditText)findViewById(R.id.email);
        ba =(EditText)findViewById(R.id.message);

        bt.setOnClickListener(this);
        sendM.setOnClickListener(this);


        exEVERYTHING();

    }


    @Override
    public void onClick(View v) {

        if(v.equals(bt)){

            Intent intent = new Intent(chating.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);
        }

        if(v.equals(sendM)){

            Tinput();

            if(vverifier(Remail,msge) == true){

                handlemsg();
            }
        }

    }

    public  boolean vverifier(String a, String b){
        boolean st= true;

        if(a.equals("")){
            aa.setError("receiver email cannot be empty");
            st=false;
        }

        if(b.equals("")){
            ba.setError("please tyoe in a message");
            st= false;
        }

        return st;

    }

    public  void Tinput(){

        Remail=aa.getText().toString().trim();
        msge=ba.getText().toString().trim();

    }



    public void handlemsg(){

        String type ="reg";
        Backchating backgroundTask = new Backchating(getApplicationContext(),"");
        backgroundTask.execute(type,ems,Remail,msge);

        aa.setText("");
        Intent intent = new Intent(chating.this,Homepage.class);
        intent.putExtra("email",ems);
        startActivity(intent);

    }

    public  void exEVERYTHING(){

        final TextView t = (TextView)findViewById(R.id.displaychats);
        ContentValues params = new ContentValues();
        params.put("email",ems);

        AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost("http://10.100.15.37/chats.php",params) {
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

                        some = " "+"email     :  "+Aw.get("semail")+"\n"+"\n"+"  "+"msg      :  "+" "+Aw.get("msg")+"\n"+"\n"+"  "+"sent to  :  "+" "+Aw.get("remail")+"\n"+"\n"+"\n"+"\n"+"  " ;
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
}
