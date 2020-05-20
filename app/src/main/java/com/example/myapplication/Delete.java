package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends AppCompatActivity  implements View.OnClickListener{

    String isbnbook="";
    //String cBOOK="";
    EditText as;
    Button deleteeboook,movescan,bk;
    TextView displayisbn;


    String ems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setTitle("DELETE BOOKS");
        Intent intent =getIntent();
        isbnbook =intent.getStringExtra("ISBN");


        displayisbn =(TextView)findViewById(R.id.isbn);
        as=(EditText) findViewById(R.id.typeinisbn);
        bk=(Button)findViewById(R.id.backk);
        deleteeboook=(Button)findViewById(R.id.deletebooks);


        Intent intenzt =getIntent();
        ems =intenzt.getStringExtra("email");


        //scans here
        movescan =(Button)findViewById(R.id.scancode);



        deleteeboook.setOnClickListener(this);
        movescan.setOnClickListener(this);
        bk.setOnClickListener(this);

        //scans here
       // Intent intent1 =getIntent();
        //isbnbook =intent.getStringExtra("ISBN");




    }

    @Override
    public void onClick(View v) {


        if(v.equals(bk)){
            Intent intent = new Intent(Delete.this,Homepage.class);
            intent.putExtra("email",ems);
            startActivity(intent);
        }



        if(v.equals(movescan)){

            Intent intent = new Intent(Delete.this,Deletescan.class);
            startActivity(intent);

        }



            if(v.equals(deleteeboook)) {

             String cBOOK =as.getText().toString().trim();


             boolean st=true;

             if(cBOOK.equals("")){
                 as.setError("type in book code");
                 st =false;
             }



             else if(st==true){
                String adress = "http://146.141.21.235/deletebook.php";
                ContentValues Content = new ContentValues();
                //remove cBOOK by "isbnbook" if you do the scan
                Content.put("ISBN", cBOOK);


                AsyncHTTPPost ident = new AsyncHTTPPost(adress, Content) {
                    @Override
                    protected void onPostExecute(String output) {
                        System.out.println(output);
                        if (output.equals("true")) {
                            Toast.makeText(getApplicationContext(), "book deleted successful", Toast.LENGTH_LONG).show();
                            Intent Home = new Intent(Delete.this, Homepage.class);
                            //Home.putExtra("name", ems);
                            startActivity(Home);
                        } else if (output.equals("false")) {

                            Toast.makeText(getApplicationContext(), "book not deleted,scan book code", Toast.LENGTH_LONG).show();

                        } else if (output.equals("0")) {
                            Toast.makeText(getApplicationContext(), "book code(isbn) does not exist", Toast.LENGTH_LONG).show();
                            Intent Home = new Intent(Delete.this, Homepage.class);
                            //Home.putExtra("name", ems);
                            startActivity(Home);
                        }
                    }
                };
                ident.execute();


            }







            }







    }
}
