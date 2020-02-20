package com.khalej.hoguzatadmin.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.Apiclient_home;
import com.khalej.hoguzatadmin.model.apiinterface_home;

public class Add_servcies_ extends AppCompatActivity {
    Intent intent;
    int id;
    private  static final int IMAGE = 100;
    ImageView imageView;
    Bitmap bitmap;
    apiinterface_home apiinterface;

    Toolbar toolbar;
    AppCompatButton regesiter;
    ProgressDialog progressDialog;
    TextInputEditText textInputEditTextname, textInputEditTextprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_servcies_);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
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
        regesiter=(AppCompatButton)findViewById(R.id.appCompatButtonRegister);
        imageView=(ImageView)findViewById(R.id.image);
        textInputEditTextname=(TextInputEditText)findViewById(R.id.textInputEditTextName);
        textInputEditTextprice=findViewById(R.id.textInputEditTextoffers);
        intent=getIntent();
        id=intent.getIntExtra("id",0);
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
            }
        });
    }
    public void fetchInfo(){


        progressDialog = ProgressDialog.show(Add_servcies_.this,"جارى تسجيل الخدمة الجديد","Please wait...",false,false);
        progressDialog.show();
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_first_servcies(id,textInputEditTextname.getText().toString()
                , Double.valueOf(textInputEditTextprice.getText().toString()));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Add_servcies_.this);
                dlgAlert.setMessage("تم تسجيل الخدمة الجديد بنجاح ");
                dlgAlert.setTitle("Hugozat App");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                regesiter.setClickable(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Add_servcies_.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
