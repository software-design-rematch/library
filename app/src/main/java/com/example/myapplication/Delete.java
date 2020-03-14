package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Delete extends AppCompatActivity  implements View.OnClickListener{

    String isbnbook="";
    Button deleteeboook,movescan;
    TextView displayisbn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setTitle("DELETE BOOKS");
        Intent intent =getIntent();
        isbnbook =intent.getStringExtra("ISBN");
        displayisbn =(TextView)findViewById(R.id.isbn);


        deleteeboook=(Button)findViewById(R.id.deletebooks);
        movescan =(Button)findViewById(R.id.scancode);



        deleteeboook.setOnClickListener(this);
        movescan.setOnClickListener(this);

        Intent intent1 =getIntent();
        isbnbook =intent.getStringExtra("ISBN");




    }

    @Override
    public void onClick(View v) {

        if(v.equals(movescan)){

            Intent intent = new Intent(Delete.this,Deletescan.class);
            startActivity(intent);

        }






            if(v.equals(deleteeboook)){
                String adress = "http://146.141.21.235/deletebook.php";
                ContentValues Content = new ContentValues();
                Content.put("ISBN", isbnbook);



                AsyncHTTPPost ident = new AsyncHTTPPost(adress, Content) {
                    @Override
                    protected void onPostExecute(String output) {
                        System.out.println(output);
                        if (output.equals("true")) {
                            Toast.makeText(getApplicationContext(),"book deleted successful",Toast.LENGTH_LONG).show();
                            Intent Home = new Intent(Delete.this, Homepage.class);
                            //Home.putExtra("name", ems);
                            startActivity(Home);
                        } else if (output.equals("false")) {

                            Toast.makeText(getApplicationContext(),"book not deleted,scan book code",Toast.LENGTH_LONG).show();

                        } else if (output.equals("0")){
                            Toast.makeText(getApplicationContext(),"book code(isbn) does not exist",Toast.LENGTH_LONG).show();
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
