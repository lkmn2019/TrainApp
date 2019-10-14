package com.example.trainapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;

import com.example.trainapp.chating.RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NetworkCheckActivity extends AppCompatActivity {

    ListView lvNetwork;
    List<HashMap<String, String>> hashMapsNetCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_check);
        hashMapsNetCheck = new ArrayList<>();
        lvNetwork = findViewById(R.id.lvNetwork);

        GetNetworkDetails();
       /* String  str2;

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str1;
                if (wifi.isChecked()){
                    llBottom.setVisibility(View.VISIBLE);
                    str1 = wifi.getTextOn().toString();
                }else {
                    llBottom.setVisibility(View.GONE);
                    str1 = wifi.getTextOff().toString();
                }
            }
        });


        if (power.isChecked()){
            str2 = power.getTextOn().toString();
            Toast.makeText(getApplicationContext(), "Power - "+str2 ,Toast.LENGTH_LONG).show();
        }else{
            str2 = power.getTextOff().toString();
        }*/
    }

    public void GetNetworkDetails(){
        for (int i = 10; i<20; i++){
            String MNPR_p_id = "ABC124"+i;
            String C_C_Id = "12433-A1-"+i;
            String Power = "ON";
            String WiFi = "OFF";

            Map<String, String> map = new LinkedHashMap<>();

            map.put("MNPR_p_id", MNPR_p_id);
            map.put("C_C_Id",C_C_Id);
            map.put("Power",Power);
            map.put("WiFi",WiFi);


            hashMapsNetCheck.add((HashMap<String, String>) map);
        }

        ListAdapter adapter = new SimpleAdapter(getApplicationContext(), hashMapsNetCheck, R.layout.net_list,
                new String[]{"MNPR_p_id", "C_C_Id", "Power", "WiFi"},
                new int[]{R.id.tv_mnvr_id, R.id.tv_coach_id, R.id.tv_power, R.id.tv_wifi}){
            public View getView(int position, View contectView , ViewGroup parent){
                View view = super.getView(position, contectView, parent);
               /* if (position %2 ==1){
                    view.setBackgroundColor(Color.parseColor("#E0E0E0"));
                }else{
                    view.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }*/
                return view;
            }
        };
        lvNetwork.setAdapter(adapter);

        lvNetwork.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NetworkCheckActivity.this, RegisterActivity.class);
                startActivity(intent);


            }
        });
    }
//menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.support:


                return true;
            case R.id.faq:
                Intent intent = new Intent(NetworkCheckActivity.this, FAQsActivity.class);
                startActivity(intent);

                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
