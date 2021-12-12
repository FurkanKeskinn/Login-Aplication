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

public class MainActivity extends AppCompatActivity {

    private EditText email_login, password_login;
    private SharedPreferences preferences ;
    private SharedPreferences.Editor editor;
    private String userEmail, userPassword;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView register_open = (TextView) findViewById(R.id.register_activity_open);
        email_login =(EditText)findViewById(R.id.edt_login_Email);
        password_login =(EditText)findViewById(R.id.edt_login_Password);

        preferences = this.getApplicationContext().getSharedPreferences("com.example.loginapplication", Context.MODE_PRIVATE);
        userEmail =preferences.getString("useremail", userEmail);
        userPassword =preferences.getString("userpassword", userPassword);

        register_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void btnSignUp(View v){
        email = email_login.getText().toString();
        password = password_login.getText().toString();
        if (!TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userPassword)){
            if (email.equals(userEmail)){
                if (password.equals(userPassword)){
                    Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, EmptyPage.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Girilen Bilgiler Yanlış", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Girilen Bilgiler Yanlış", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Lütfen Bilgileri Eksiksiz Doldurun", Toast.LENGTH_SHORT).show();
        }

    }
}