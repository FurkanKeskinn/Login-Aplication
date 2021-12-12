package com.example.loginapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullname_register, email_register, phone_register, password_register;
    private SharedPreferences preferences ;
    private SharedPreferences.Editor editor;
    private String userFullname, userEmail, userPhone, userPassword;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView login_open = (TextView) findViewById(R.id.login_activity_open);
        fullname_register = (EditText)findViewById(R.id.edt_register_Fullname);
        email_register = (EditText)findViewById(R.id.edt_register_Email);
        phone_register = (EditText)findViewById(R.id.edt_register_Phone);
        password_register = (EditText)findViewById(R.id.edt_register_Password);

        login_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        preferences = this.getSharedPreferences("com.example.loginapplication", Context.MODE_PRIVATE);

    }
    public void btnSignIn(View v){
        userFullname = fullname_register.getText().toString();
        userEmail = email_register.getText().toString();
        userPhone = phone_register.getText().toString();
        userPassword = password_register.getText().toString();

        if (!TextUtils.isEmpty(userFullname) && !TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userPhone) && !TextUtils.isEmpty(userPassword)){
            editor = preferences.edit();
            editor.putString("userfullname", userFullname);
            editor.putString("useremail", userEmail);
            editor.putString("userphone", userPhone);
            editor.putString("userpassword", userPassword);
            editor.apply();
            editor.commit();

            Toast.makeText(getApplicationContext(), "Kullanıcı Kaydı Başarılı Bir Şekilde Yapıldı.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(getApplicationContext(), "Lütfen Bilgileri Eksiksiz Doldurun", Toast.LENGTH_SHORT).show();
        }
    }
}