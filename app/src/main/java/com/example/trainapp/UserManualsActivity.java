package com.example.trainapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserManualsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtDate, txtLat, txtAddress, txtUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manuals);

        Bitmap bitmap;
        byte[] bytes = getIntent().getByteArrayExtra("image");
        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        String name = getIntent().getStringExtra("name");
        String date = getIntent().getStringExtra("date");
        String lat = getIntent().getStringExtra("lat");
        String address = getIntent().getStringExtra("add");

        imageView = findViewById(R.id.iv);
        txtDate = findViewById(R.id.txtDate);
        txtLat = findViewById(R.id.txtLat);
        txtAddress = findViewById(R.id.txtadd);
        txtUserName = findViewById(R.id.txtUsername);

        imageView.setImageBitmap(bitmap);
        txtUserName.setText(name);
        txtDate.setText(date);
        txtLat.setText(lat);
        txtAddress.setText(address);

    }
}
