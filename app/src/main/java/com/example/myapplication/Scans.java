package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scans extends AppCompatActivity {





    private ZXingScannerView scannerView;
    String res="",ems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scans);
        Intent intent =getIntent();
        ems=intent.getStringExtra("email");
    }


    public  void  scancode(View view){

        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new Scans.ZXingscannerResultsHandler());


        setContentView(scannerView);
        scannerView.startCamera();

    }

    @Override
    public void onPause(){

        super.onPause();
        scannerView.stopCamera();
    }

    class ZXingscannerResultsHandler implements  ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(Result result) {

            res =result.getText();
            Toast.makeText(getApplicationContext(),res, Toast.LENGTH_SHORT).show();
            //setContentView(R.layout.activity_add_books);
            if(!res.equals("")){
                scannerView.stopCamera();
                Intent intent = new Intent(Scans.this,AddBooks.class);
                intent.putExtra("ISBN",res);
                intent.putExtra("emaial",ems);
                startActivity(intent);

            }

        }
    }








































}
