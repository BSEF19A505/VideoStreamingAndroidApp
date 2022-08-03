package com.example.backgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class BG extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("Mahad", "onPreExecute: ran");
        }

        @Override
        protected String doInBackground(String... urls) {
            Log.d("Mahad", "doInBackground: ran");
           String result="";
            HttpURLConnection con;
            URL url;

            try {
                 url= new URL(urls[0]);

                con= (HttpURLConnection) url.openConnection();
                InputStream in=con.getInputStream() ;
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                if(data!=-1){
                    char current=(char) data;
                    result += current;
                    data=reader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Something Went Wrong");
            }
            return result;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Mahad", "onPreExecute: ran");
            Log.d("Mahad", s);
        }
    }
    public void click(View view){
        Toast.makeText(this, "Running Background Task", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                BG task=new BG();
                task.execute("https://www.codewithharry.com/");

    }
}