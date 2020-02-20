package com.khalej.hoguzatadmin.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import com.khalej.hoguzatadmin.R;
import com.khalej.hoguzatadmin.model.Apiclient_home;
import com.khalej.hoguzatadmin.model.apiinterface_home;
import com.khalej.hoguzatadmin.model.contact_userinfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    AppCompatButton Naccount;
    AppCompatButton login, textViewLinkguest;
    TextInputEditText textInputEditTextphone, textInputEditTextpassword;
    TextInputLayout textInputLayoutphone, textInputLayoutpassword;
    private List<contact_userinfo> contactList;
    private apiinterface_home apiinterface;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    ProgressDialog progressDialog;
    String codee;
    LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Droid.ttf", true);


        textInputLayoutphone = (TextInputLayout) findViewById(R.id.textInputLayoutphone);
        textInputLayoutpassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputEditTextphone = (TextInputEditText) findViewById(R.id.textInputEditTextphone);

        textViewLinkguest = findViewById(R.id.textViewLinkguest);


        sharedpref = getSharedPreferences("Education", Context.MODE_PRIVATE);
        edt = sharedpref.edit();

        if (sharedpref.getString("remember", "").trim().equals("yes")) {
            edt.putFloat("totalprice", 0);
            edt.apply();
            startActivity(new Intent(Login.this, MainActivity.class));

            finish();
        }
        textInputEditTextpassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        Naccount = (AppCompatButton) findViewById(R.id.textViewLinkRegister);

        login = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           if(textInputEditTextphone.getText().toString().equals("123")&&textInputEditTextpassword.getText().toString().equals("123")){
                startActivity(new Intent(Login.this,MainActivity.class));}
                else{
                    Toast.makeText(Login.this, "خطأ برقم الهاتف او كلمة المرور" ,Toast.LENGTH_LONG).show();
                   }
            }
        });

    }


}