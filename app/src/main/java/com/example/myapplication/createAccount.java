package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class createAccount extends AppCompatActivity implements View.OnClickListener{


    TextView a,b,c,d,e,lg;
    String nnn="";
    Button cre;
    String na,sur,em,ps,pss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);








        getSupportActionBar().setTitle("CREATE ACCOUNT");
        lg=(TextView)findViewById(R.id.loginini);
        a =(TextView)findViewById(R.id.names);
        b =(TextView)findViewById(R.id.surname);
        c =(TextView)findViewById(R.id.emailA);
        d =(TextView)findViewById(R.id.pass);
        e=(TextView)findViewById(R.id.confirm);
        cre =(Button)findViewById(R.id.createA);

        cre.setOnClickListener(this);
        lg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.equals(cre)){






//            String na = a.getText().toString();
//            String sur =b.getText().toString();
//            String em  =c.getText().toString();
//            String ps =d.getText().toString();
//            String pss=e.getText().toString();

            takeinput();

//            boolean state = true;
//            if(na.equals("")){
//                state = false;
//                a.setError("please input name(s)");
//            }
//            if(sur.equals("")){
//                state = false;
//                b.setError("surname can not be empty");
//            }
//            if(em.equals("")){
//                state = false;
//                c.setError("email address can not be empty");
//            }
//            if(ps.equals("")){
//                state = false;
//                d.setError("password can not be empty");
//            }
//
//            if(!pss.equals(ps)){
//                state = false;
//                e.setError("password did not match");
//
//            }
//            if(nnn.equals("")){
//                Toast.makeText(getApplicationContext(),"please select your gender",Toast.LENGTH_SHORT).show();
//                state = false;
//            }
//

            if(verifyinput(na,sur,em,ps,pss,nnn) ==  true){

                    String type ="reg";
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext(),"");
                    backgroundTask.execute(type, na, sur, em,nnn, ps);

                    a.setText("");
                    b.setText("");
                    c.setText("");
                    d.setText("");
                    e.setText("");




            }














            }



            if(v.equals(lg)){

               Intent intent = new Intent(createAccount.this,Login.class);
               startActivity(intent);


            }










    }




    public  boolean verifyinput(String na,String sur,String em,String ps,String pss,String nnn){


        boolean state = true;
        if(na.equals("")){
            state = false;
            a.setError("please input name(s)");
        }
        if(sur.equals("")){
            state = false;
            b.setError("surname can not be empty");
        }
        if(em.equals("")){
            state = false;
            c.setError("email address can not be empty");
        }
        if(ps.equals("")){
            state = false;
            d.setError("password can not be empty");
        }

        if(!pss.equals(ps)){
            state = false;
            e.setError("password did not match");

        }
        if(nnn.equals("")){
            Toast.makeText(getApplicationContext(),"please select your gender",Toast.LENGTH_SHORT).show();
            state = false;
        }




        return state;
    }


    public void takeinput(){

             na = a.getText().toString();
             sur =b.getText().toString();
             em  =c.getText().toString();
             ps =d.getText().toString();
             pss=e.getText().toString();



    }



    public void dogen(View v){
        boolean checked =((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.male:
                nnn = "Male";
                break;

            case R.id.female:
                nnn ="Female";
                break;
        }

    }



}
