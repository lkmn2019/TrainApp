package com.example.trainapp.chating;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trainapp.R;
import com.example.trainapp.WifiActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText userName, userPassword;
    Button btnMnvrLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.et_name);
        userPassword = (EditText) findViewById(R.id.et_password);

        btnMnvrLogin = findViewById(R.id.btn_nmvr_login);

        btnMnvrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String pass = userPassword.getText().toString();
                if (name.isEmpty() || pass.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }else{
                    if (name.equals("sonu") && pass.equals("12345")){
                        Intent intent = new Intent(RegisterActivity.this, WifiActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(), "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

}
