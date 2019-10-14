package com.example.trainapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.trainapp.chating.RegisterActivity;
import com.example.trainapp.map.MapsActivity;

public class WifiActivity extends AppCompatActivity {

    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        btnProceed = findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WifiActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    //menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                Intent intent = new Intent(WifiActivity.this, RegisterActivity.class);
                startActivity(intent);

                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
