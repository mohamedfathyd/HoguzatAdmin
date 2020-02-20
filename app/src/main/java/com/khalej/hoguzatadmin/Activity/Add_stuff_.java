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
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.Apiclient_home;
import com.khalej.hoguzatadmin.model.apiinterface_home;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Add_stuff_ extends AppCompatActivity {
    Intent intent;
    int id;
    private  static final int IMAGE = 100;
    ImageView imageView;
    Bitmap bitmap;
    apiinterface_home apiinterface;

    Toolbar toolbar;
    AppCompatButton regesiter;
    ProgressDialog progressDialog;
TextInputEditText textInputEditTextname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stuff_);
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

        intent=getIntent();
        id=intent.getIntExtra("id",0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
            }
        });
    }
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE);
    }
    private String convertToString()
    {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
                regesiter.setClickable(false);
            }
        });
    }

    public void fetchInfo(){

        String image="";
        try{
            image = convertToString();}
        catch (Exception e){
            Toast.makeText(Add_stuff_.this,"من فضلك اختر صورة" , Toast.LENGTH_LONG).show();
            return;

        }
        progressDialog = ProgressDialog.show(Add_stuff_.this,"جارى تسجيل العامل الجديد","Please wait...",false,false);
        progressDialog.show();
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_first_stuff(id,textInputEditTextname.getText().toString()
                ,image);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(Add_stuff_.this);
                dlgAlert.setMessage("تم تسجيل العامل الجديد بنجاح ");
                dlgAlert.setTitle("Hugozat App");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                regesiter.setClickable(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Add_stuff_.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
