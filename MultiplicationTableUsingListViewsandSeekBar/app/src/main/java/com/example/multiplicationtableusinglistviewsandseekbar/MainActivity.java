package com.example.multiplicationtableusinglistviewsandseekbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seek;
    ListView listView;
    TextView textView;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.ListView);

        seek=findViewById(R.id.seekBar);

        seek.setMax(20);
        seek.setMin(1);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                table(i);
            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void table(int num){
        textView=findViewById(R.id.textView7);
        ArrayList<String> rows=new ArrayList<>();
        for(int i=1;i<=10;i++){
            rows.add(num+" x "+i+" = "+(num*i));
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,rows);
        listView.setAdapter(adapter);
        textView.setText("Table of "+num);
    }
}