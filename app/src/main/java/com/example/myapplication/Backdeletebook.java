package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backdeletebook extends AsyncTask<String, String, String> {

    Context context;
    static   String retx="";
    Backdeletebook(Context ctx,String sa) {
        this.context = ctx;
        this.retx = sa;
    }



    @Override

    protected String doInBackground(String... strings) {
        String type = strings[0];
        String ISBN = strings[1];

        String regURL = "http://192.168.43.68/deletebook.php";
        if (type.equals("reg")) {
            try {
                URL url = new URL(regURL);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String insert_data = URLEncoder.encode("ISBN", "UTF-8") + "=" + URLEncoder.encode(ISBN, "UTF-8") ;
                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result = "";

                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                        //stringBuilder.append(line).append("\n");
                    }

                    //result = stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    //retx =result;
                    return result;
                }catch (IOException e) {
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s){
        //retx =s;
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        ///Toast.makeText(context.getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }











}
