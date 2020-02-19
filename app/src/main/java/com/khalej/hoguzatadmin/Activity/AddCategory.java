package com.khalej.hoguzatadmin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.khalej.hoguzatadmin.R;

public class AddCategory extends AppCompatActivity {
    RelativeLayout relativelayout1,relativelayout2,relativelayout3,relativelayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        relativelayout1=findViewById(R.id.relativelayout1);
        relativelayout2=findViewById(R.id.relativelayout2);
        relativelayout3=findViewById(R.id.relativelayout3);
        relativelayout4=findViewById(R.id.relativelayout4);
        relativelayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddCategory.this,Salon.class);
                intent.putExtra("name","الصوالين الصحية");
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
        relativelayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddCategory.this,CardView.class);
                intent.putExtra("id",2);
               intent.putExtra("category",1);
                startActivity(intent);

            }
        });
        relativelayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddCategory.this,CardView.class);
                intent.putExtra("id",3);
                intent.putExtra("category",1);
                startActivity(intent);
            }
        });
        relativelayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddCategory.this,CardView.class);
                intent.putExtra("id",4);
                intent.putExtra("category",1);
                startActivity(intent);
            }
        });
    }
}
