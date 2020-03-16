package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddBooks extends AppCompatActivity implements View.OnClickListener {

    Bundle b;
    String emss="",e;
    String srcc="";
    TextView isbnd;
    private static  String res="ggg";
    Button p,nxt,sc,ems;
    String code="";
    EditText nameofbook,shelfname,authorname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        getSupportActionBar().setTitle("ADD BOOKS");



        isbnd =(TextView)findViewById(R.id.isbnn);
        shelfname=(EditText)findViewById(R.id.booklocation);
        authorname=(EditText)findViewById(R.id.author);
        nameofbook =(EditText)findViewById(R.id.bookname);
        nxt =(Button)findViewById(R.id.nextt);
        //isbnd.setOnClickListener(this);
        p=(Button)findViewById(R.id.dp);
        sc =(Button)findViewById(R.id.scancode);


        Intent intent =getIntent();
        srcc =intent.getStringExtra("ISBN");

        Intent intent1 =getIntent();
        emss =intent1.getStringExtra("email");
        Intent intent2 =getIntent();
        e=intent2.getStringExtra("emaial");
        //b = intent.getExtras();
        nxt.setOnClickListener(this);
        sc.setOnClickListener(this);
        p.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {


        if (view.equals(sc)) {

            Intent intent = new Intent(AddBooks.this, Scans.class);
            intent.putExtra("email",emss);
            startActivity(intent);


        }


        if (view.equals(nxt)) {

            //String bookcode = srcc;
            String namebook = nameofbook.getText().toString();
            String nameSHELF = shelfname.getText().toString();
            String nameAUTHOR = authorname.getText().toString();


            boolean stated = true;


            if (srcc.equals("")) {
                isbnd.setError("scan isbn code");
                stated = false;
            }
            if (namebook.equals("")) {
                nameofbook.setError("book name can not be empty");
                stated = false;
            }
            if (nameSHELF.equals("")) {
                stated = false;
                shelfname.setError("book location can not be empty");
            }
            if (nameAUTHOR.equals("")) {
                stated = false;
                authorname.setError("author name can not be empty");

            } else if (stated == true) {


                String type = "reg";
                bookinfobackground backgroundTask = new bookinfobackground(getApplicationContext(),"");
                backgroundTask.execute(type, srcc, namebook, nameAUTHOR, nameSHELF,e);
                nameofbook.setText("");
                shelfname.setText("");
                authorname.setText("");
                isbnd.setText("");

                Intent intent = new Intent(AddBooks.this,Homepage.class);
                intent.putExtra("email",e);
                startActivity(intent);


            }


        }



        if(view.equals(p)){


            Intent intent =getIntent();
            srcc =intent.getStringExtra("ISBN");

        isbnd.setText(srcc);


        }







            /*if (b != null) {
                if (view.equals(p)) {
                    //String k="";
                    //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();

                    String j = (String) b.get("ISBN");
                    code = j;

                    isbnd.setText(code);
                    //Intent intent = new Intent(AddBooks.this,Homepage.class);
                    //startActivity(intent);
                }
            }*/



    }}
