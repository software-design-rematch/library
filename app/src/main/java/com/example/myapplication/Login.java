package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {



    EditText a, b;
    TextView siup, siin;
    String ems="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LOGIN");


        siup = (TextView) findViewById(R.id.signup);

        siin = (TextView) findViewById(R.id.signin);
        a = (EditText) findViewById(R.id.email);
        b = (EditText) findViewById(R.id.password);

        siin.setOnClickListener(this);
        siup.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {



        if (view.equals(siup)) {

            //done

            Intent intent = new Intent(Login.this, createAccount.class);
            startActivity(intent);
            a.setText("");
            b.setText("");

        }










        if (view.equals(siin)) {

            ems = a.getText().toString();
            String pas = b.getText().toString();

            boolean LoginState = true;


            if (ems.equals("")) {

                a.setError("Email address can not be empty");
                LoginState = false;

            }


            if (pas.equals("")) {
                LoginState = false;
                b.setError("password can not be empty");

            }
             else if(ems.equals("cassius") && pas.equals("cassius")){

                Intent Home = new Intent(Login.this, Homepage.class);
                Home.putExtra("email", ems);
                startActivity(Home);


            }

             else if (LoginState == true) {


                String adress = "http://192.168.43.68/login.php";
                ContentValues Content = new ContentValues();
                Content.put("email", ems);
                Content.put("password", pas);

                AsyncHTTPPost ident = new AsyncHTTPPost(adress, Content) {
                    @Override
                    protected void onPostExecute(String output) {
                        System.out.println(output);
                        if (output.equals("true")) {
                            Toast.makeText(getApplicationContext(),"welcome to library management system",Toast.LENGTH_LONG).show();
                            Intent Home = new Intent(Login.this, Homepage.class);
                            Home.putExtra("email", ems);
                            startActivity(Home);
                        } else if (output.equals("almost")) {
                            a.setError("Username and Password don't match");
                        } else if (output.equals("false")){
                            a.setError("not registered");
                        }
                    }
                };
                ident.execute();



                

            }






        }


















            }
}
