package com.khalej.hoguzatadmin.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.khalej.hoguzatadmin.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import me.anwarshahriar.calligrapher.Calligrapher;

public class Salon extends AppCompatActivity {
    RelativeLayout relativelayout2,relativelayout1;
    AppCompatTextView selectCountry;
    Intent intent;
    int id;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    int country=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
        relativelayout1=findViewById(R.id.relativelayout);
        relativelayout2=findViewById(R.id.relativelayout2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        intent=getIntent();
        sharedpref = getSharedPreferences("Education", Context.MODE_PRIVATE);
        edt = sharedpref.edit();

        TextView toolbar_title=findViewById(R.id.toolbar_title);
        toolbar_title.setText(intent.getStringExtra("name"));
        id=intent.getIntExtra("id",0);
        setSupportActionBar(toolbar);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);
        this.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        selectCountry=findViewById(R.id.appCompatButtonLogin);
        selectCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Dialog dialog = new Dialog(Salon.this);
//                dialog.setContentView(R.layout.dialog_details2);
//
//                List<Integer> lstImages = new ArrayList<>();
//                lstImages.add(R.drawable.bahrain);
//                lstImages.add(R.drawable.oman);
//                lstImages.add(R.drawable.qatar);
//                lstImages.add(R.drawable.emarat);
//                lstImages.add(R.drawable.kwait);
//                HorizontalInfiniteCycleViewPager pager = dialog.findViewById(R.id.horizontal_cycle);
//                final RelativeLayout relativelayout=dialog.findViewById(R.id.relativelayout);
//                MyAdapter adapter = new MyAdapter(lstImages,getBaseContext());
//                pager.setAdapter(adapter);
//                pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                    @Override
//                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                        String x= String.valueOf(position);
//                   char y=x.charAt(x.length()-1);
//                   if(y=='0'||y=='5'){
//                       selectCountry.setText("البحرين");
//                      country=1;
//                  relativelayout.setBackgroundResource(R.drawable.b);
//                   }
//                        if(y=='1'||y=='6'){
//                            selectCountry.setText("عمان");
//                            country=2;
//                            relativelayout.setBackgroundResource(R.drawable.o);
//                       }
//                        if(y=='2'||y=='7'){
//                            selectCountry.setText("قطر");
//                            country=3;
//                            relativelayout.setBackgroundResource(R.drawable.q);
//                        }
//                        if(y=='3'||y=='8'){
//                            selectCountry.setText("الإمارات");
//                            country=3;
//                            relativelayout.setBackgroundResource(R.drawable.e);
//                        }
//                        if(y=='4'||y=='9'){
//                            selectCountry.setText("الكويت");
//                            country=3;
//                            relativelayout.setBackgroundResource(R.drawable.k);
//                        }
//                    }
//
//                    @Override
//                    public void onPageSelected(int position) {
//
//                    }
//
//                    @Override
//                    public void onPageScrollStateChanged(int state) {
//
//                    }
//                });
//           relativelayout.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   dialog.dismiss();
//               }
//           });
//                dialog.setTitle("اختر الدولة التى تريدها");
//                LinearLayout a,b,c,d,e;
//                a=dialog.findViewById(R.id.a);
//                b=dialog.findViewById(R.id.b);
//                c=dialog.findViewById(R.id.c);
//                d=dialog.findViewById(R.id.d);
//                e=dialog.findViewById(R.id.e);
//                a.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        selectCountry.setText("البحرين");
//                        country=1;
//                        dialog.dismiss();
//                    }
//                });
//                b.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        selectCountry.setText("عمان");
//                        country=2;
//                        dialog.dismiss();
//                    }
//                });
//                c.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        selectCountry.setText("قطر");
//                        country=3;
//                        dialog.dismiss();
//                    }
//                });
//                d.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        selectCountry.setText("الأمارات");
//                        country=4;
//                        dialog.dismiss();
//                    }
//                });
//                e.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        selectCountry.setText("الكويت");
//                        country=5;
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
            }
        });
        relativelayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Salon.this,CardView.class);
                intent.putExtra("id",id);
                intent.putExtra("category",1);
                startActivity(intent);
            }
        });
        relativelayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Salon.this,CardView.class);
                intent.putExtra("id",id);
                intent.putExtra("category",2);
                startActivity(intent);
            }
        });
    }
}
