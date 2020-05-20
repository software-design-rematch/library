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
    Button p,nxt,sc,ems,bk;
    String code="";

    String fttt="a";

    EditText nameofbook,shelfname,authorname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        getSupportActionBar().setTitle("ADD BOOKS");


        bk=(Button)findViewById(R.id.back);
        isbnd =(TextView)findViewById(R.id.isbnn);
        shelfname=(EditText)findViewById(R.id.booklocation);
        authorname=(EditText)findViewById(R.id.author);
        nameofbook =(EditText)findViewById(R.id.bookname);
        nxt =(Button)findViewById(R.id.nextt);
        //isbnd.setOnClickListener(this);
        p=(Button)findViewById(R.id.dp);
        sc =(Button)findViewById(R.id.scancode);



        //here for scan
         //Intent intent =getIntent();
        //srcc =intent.getStringExtra("ISBN");




        Intent intent1 =getIntent();
        emss =intent1.getStringExtra("email");





        //here for scans
        //Intent intent2 =getIntent();
        //e=intent2.getStringExtra("emaial");






        //b = intent.getExtras();
        nxt.setOnClickListener(this);
        sc.setOnClickListener(this);
        p.setOnClickListener(this);
        bk.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {


        if(view.equals(bk)){

            Intent intent = new Intent(AddBooks.this, Homepage.class);
            intent.putExtra("email",emss);
            startActivity(intent);


        }




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


            //here for scan
            /*if (srcc.equals("")) {
                isbnd.setError("scan isbn code");
                stated = false;
            }*/


            if (namebook.equals("")) {
                nameofbook.setError("book name and ISBN can not be empty");
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


                String bookcodeandisbn[] =namebook.split(",");

                String bookksname =bookcodeandisbn[0];
                String ISBNCODEFINAL=bookcodeandisbn[1];

                if(ISBNCODEFINAL.equals("")) {ISBNCODEFINAL = fttt;}


                String type = "reg";
                bookinfobackground backgroundTask = new bookinfobackground(getApplicationContext(),"");
                //ND ,if you scan,remove emss by e
                backgroundTask.execute(type, ISBNCODEFINAL, bookksname, nameAUTHOR, nameSHELF,emss);
                nameofbook.setText("");
                shelfname.setText("");
                authorname.setText("");



                //scans here.....
                //isbnd.setText("");





                Intent intent = new Intent(AddBooks.this,Homepage.class);
                //ND ,if you scan,remove emss by e
                intent.putExtra("email",emss);
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
