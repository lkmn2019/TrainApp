package com.example.trainapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.trainapp.utils.CommonMethod;
import com.example.trainapp.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int i = 0;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final String userrname = CommonMethod.getPrefsData(getApplicationContext(), Constants.PREF_USERNAME, "");

        progressBar = findViewById(R.id.progressBar1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100){
                    i+=5;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(i);
                            if (i == 100) {
                                if (userrname.equals("")) {
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }
                    });
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.getMessage();
                    }
                }
            }
        }).start();

       /* Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(1000);

                    if (userrname.equals("")){
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();

                    }else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();*/
    }
}
