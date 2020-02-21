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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.Apiclient_home;
import com.khalej.hoguzatadmin.model.apiinterface_home;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CardView extends AppCompatActivity {
    Intent intent;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayList<Integer> arrayList_id=new ArrayList<>();
    apiinterface_home apiinterface;
    AppCompatButton regesiter;
    private  static final int IMAGE = 100;
    ImageView imageView;
    Toolbar toolbar;
    int category_id;
    Button location;
    Bitmap bitmap;
    ProgressDialog progressDialog;
    Spinner spinner;
    TextInputLayout textInputLayoutname,textInputLayoutaddress,textInputLayoutphone;
    TextInputEditText textInputEditTextname,textInputEditTextNameAR,textInputEditTextphone,textInputEditTextcity;
    Double lat;
    Double lng;
    int getCategory_id;
    int gender_id;
    int country=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        initializer();
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
        intent=getIntent();
        lat=intent.getDoubleExtra("lat",0.0);
        lng=intent.getDoubleExtra("lng",0.0);
        getCategory_id=intent.getIntExtra("id",0);
        gender_id=intent.getIntExtra("category",0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country=position+1;
                 }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        regesiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
                regesiter.setClickable(false);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CardView.this,MapsActivity.class);
                intent.putExtra("id",getCategory_id);
                intent.putExtra("category",gender_id);
                startActivity(intent);
            }
        });
    }
    public void initializer(){

        imageView=(ImageView)findViewById(R.id.image);
        location=findViewById(R.id.location);
        textInputLayoutname=(TextInputLayout)findViewById(R.id.textInputLayoutName);
        spinner=findViewById(R.id.spin);
        textInputEditTextname=(TextInputEditText)findViewById(R.id.textInputEditTextName);
        textInputEditTextNameAR=(TextInputEditText)findViewById(R.id.textInputEditTextDeatails);
        textInputEditTextphone=findViewById(R.id.textInputEditTextoffers);
        textInputEditTextcity=findViewById(R.id.textInputEditTextcity);
        regesiter=(AppCompatButton)findViewById(R.id.appCompatButtonRegister);
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

    }
    public void fetchInfo(){

        String image="";
        try{
            image = convertToString();}
        catch (Exception e){
            Toast.makeText(CardView.this,"من فضلك اختر صورة" , Toast.LENGTH_LONG).show();
            return;

        }
        if(lat==0.0||lng==0.0){
            Toast.makeText(CardView.this,"من فضلك حدد الموقع على الخريطة" , Toast.LENGTH_LONG).show();
            return;

        }
        progressDialog = ProgressDialog.show(CardView.this,"جارى تسجيل الأعلان الجديد","Please wait...",false,false);
        progressDialog.show();
        apiinterface= Apiclient_home.getapiClient().create(apiinterface_home.class);
        Call<ResponseBody> call = apiinterface.getcontacts_add_first_category(getCategory_id,textInputEditTextname.getText().toString()
                ,textInputEditTextNameAR.getText().toString(),textInputEditTextphone.getText().toString()
                ,image,country,lat,lng,gender_id,textInputEditTextcity.getText().toString());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();

                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(CardView.this);
                dlgAlert.setMessage("تم تسجيل الأعلان بنجاح ");
                dlgAlert.setTitle("Hugozat App");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                regesiter.setClickable(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(CardView.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
