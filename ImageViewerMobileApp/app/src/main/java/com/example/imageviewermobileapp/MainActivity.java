package com.example.imageviewermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int counter=0;
    public void next(View view)
    {

        String image="image"+counter;

        int x = this.getResources().getIdentifier(image, "id", getPackageName());
        img= findViewById(x);
        img.setAlpha(0f);

        counter=(counter+1)%5;
        String imagey="image"+counter;
        int y = this.getResources().getIdentifier(imagey, "id", getPackageName());
        img=findViewById(y);
        img.setAlpha(1f);
    }
    public void prev(View view)
    {

        String image="image"+counter;

        int x = this.getResources().getIdentifier(image, "id", getPackageName());
        img= findViewById(x);
        img.setAlpha(0f);

        counter=(5+counter+1)%5;
        String imagey="image"+counter;
        int y = this.getResources().getIdentifier(imagey, "id", getPackageName());
        img=findViewById(y);
        img.setAlpha(1f);
    }
}