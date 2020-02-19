package com.khalej.hoguzatadmin.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khalej.hoguzatadmin.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button order, add ,delete ,addStuff,addservcies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order=findViewById(R.id.order);
        add=findViewById(R.id.add);
        delete=findViewById(R.id.delete);
        addservcies=findViewById(R.id.addservcies);
        addStuff=findViewById(R.id.addstuff);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           startActivity(new Intent(MainActivity.this,Orders.class));
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete_category.class));

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddCategory.class));
            }
        });
    }
}
