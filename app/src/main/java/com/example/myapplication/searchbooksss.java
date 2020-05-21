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

                String ad="http://192.168.43.68/searchbook.php";
                ContentValues params= new ContentValues();
                params.put("searchkey",nora);

                AsyncHTTPPost asyncHTTPPost = new AsyncHTTPPost(ad,params) {
                    @Override
                    protected void onPostExecute(String output) {

                        JSONArray T = null;

                        try{


                            T = new JSONArray(output);
                            int aa= T.length();
                            String Arr1[] = new String[aa];

                            for(int i=0;i<T.length();i++){
                                String some="";
                                JSONObject Aw =(JSONObject)T.get(i);

                                some = "book code   :  " +Aw.get("isbn")+"\n"+"\n"+"\n"+"book name   :  "+Aw.get("bookname")+"\n"+"\n"+"\n"+
                                        "author name :  "+Aw.get("author")+"\n"+"\n"+"\n"+"book location  :"+Aw.get("location")+"\n"+"\n"+"\n";
                                Arr1[i] =some;

                            }


                            TextView inforBOOKS=(TextView) findViewById(R.id.displayinfo);
                            String pr="";
                            /*for(int i =0;i<Arr1.length;i++){
                                pr += Arr1[i]+"\n";

                            }*/
                             if(pr.equals("")){
                                 inforBOOKS.setText("book not found");
                             }
                         else {   inforBOOKS.setText(pr);}

                        }
                        catch (JSONException k){

                            k.printStackTrace();
                        }






                    }
                };

                asyncHTTPPost.execute();



                             }




        }


    }
}
