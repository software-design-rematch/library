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

public class bookinfobackground extends AsyncTask<String, String, String> {


    Context context;
    static String retx = "";

    bookinfobackground(Context ctx,String a) {
        this.context = ctx;
        this.retx =a;

    }

    @Override

    protected String doInBackground(String... strings) {
        String type = strings[0];
        String isbn = strings[1];
        String bookname = strings[2];
        String author = strings[3];
        String location = strings[4];
        String email = strings[5];
        String regURL = "http://146.141.21.235/addbook.php";
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
                    String insert_data = URLEncoder.encode("isbn", "UTF-8") + "=" + URLEncoder.encode(isbn, "UTF-8") +
                            "&" + URLEncoder.encode("bookname", "UTF-8") + "=" + URLEncoder.encode(bookname, "UTF-8") +
                            "&" + URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(author, "UTF-8") +
                            "&" + URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(location, "UTF-8") +
                            "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
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
                } catch (IOException e) {
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        //retx =s;
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        ///Toast.makeText(context.getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    }





