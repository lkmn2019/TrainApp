package com.example.trainapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FAQsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
