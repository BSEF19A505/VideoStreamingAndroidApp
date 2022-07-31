package com.example.listviewspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listView);
        ArrayList<String> groceryItems=new ArrayList<>();
        groceryItems.add("Bread");
        groceryItems.add("Butter");
        groceryItems.add("Eggs");
        groceryItems.add("Jam");
        groceryItems.add("Rusk");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,groceryItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item no "+i+" "+
                        ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}