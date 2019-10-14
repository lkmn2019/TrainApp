package com.example.trainapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trainapp.utils.CommonMethod;
import com.example.trainapp.utils.Constants;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.login);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2;
                str1 = et_username.getText().toString();
                str2 = et_password.getText().toString();

                if (str1.isEmpty() && str2.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter uresname and password!", Toast.LENGTH_SHORT).show();
                }else {
                    if (str1.equals("sonu")&& str2.equals("12345")) {
                        CommonMethod.setPrefsData(getApplicationContext(), Constants.PREF_USERNAME, str1);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Entered uresname and password not correct!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
