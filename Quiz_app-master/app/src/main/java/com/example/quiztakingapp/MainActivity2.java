package com.example.quiztakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        int score=intent.getIntExtra("Score",0);
        String msg;
        if(score>=7){
            msg="Congratulations, You got "+score+" out of 10. You have passed the exam.";
        }
        else{
            msg="Sorry, You got "+score+" out of 10.  Try next time.";
        }
        txtView=findViewById(R.id.textView2);
        txtView.setText(msg);
    }
}