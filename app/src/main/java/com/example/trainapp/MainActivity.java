package com.example.trainapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.trainapp.utils.CommonMethod;
import com.example.trainapp.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<HashMap<String, String>> hashMapsTrain;
    ListView lvTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hashMapsTrain = new ArrayList<>();
        lvTrain = findViewById(R.id.lvTrain);
        GetTrainDetails();
    }

    public void GetTrainDetails(){
        String t1= "CHENNAI RAJDHANI";
        String n1 = "(12434)";
        String s1 = "H Nizamuddin(NZM)";
        String e1 = "Chennai Central(MAS)";
        String st1 = "15:55";
        String et1 = "20:45";
        String tt1 = "28:20 Hrs";
        //-----------------
        String t2= "TAMIL NADU EXP";
        String n2 = "(12621)";
        String s2 = "Chennai Central(MAS)";
        String e2 = "New Delhi(NDLS)";
        String st2 = "22:00";
        String et2 = "07:05";
        String tt2 = "33:05 Hrs";
        //----------------------
        String t3= "RAJDHANI EXP";
        String n3 = "(12433)";
        String s3 = "Chennai Central(MAS)";
        String e3 = "H Nizamuddin(NZM)";
        String st3 = "10:25";
        String et3 = "20:45";
        String tt3 = "28:20 Hrs";
        //--------------------------
        String t4= "DURONTO EXPRESS";
        String n4 = "(12269)";
        String s4 = "Chennai Central(MAS)";
        String e4 = "H Nizamuddin(NZM)";
        String st4 = "06:40";
        String et4 = "10:35";
        String tt4 = "27:55 Hrs";
        //------------------------
        String t5= "NZM GARIB RATH";
        String n5 = "(12611)";
        String s5 = "Chennai Central(MAS)";
        String e5 = "H Nizamuddin(NZM)";
        String st5 = "06:05";
        String et5 = "10:30";
        String tt5 = "28:25 Hrs";
        //-----------------------
        String t6= "TIRUKKURAL EXP";
        String n6 = "(12641)";
        String s6 = "Chennai Egmore(MS)";
        String e6 = "H Nizamuddin(NZM)";
        String st6 = "09:05";
        String et6 = "18:00";
        String tt6 = "32:55 Hrs";

        for (int i = 1; i<13; i++){
            Map<String, String> map = new LinkedHashMap<>();



            if (i==1){
                map.put("TrainName", t1);
                map.put("TrainNo",n1);
                map.put("StartStation",s1);
                map.put("EndStation",e1);
                map.put("StartTime",st1);
                map.put("EndTime",et1);
                map.put("TravelTime", tt1);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==2){
                map.put("TrainName", t2);
                map.put("TrainNo",n2);
                map.put("StartStation",s2);
                map.put("EndStation",e2);
                map.put("StartTime",st2);
                map.put("EndTime",et2);
                map.put("TravelTime", tt2);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==3){
                map.put("TrainName", t3);
                map.put("TrainNo",n3);
                map.put("StartStation",s3);
                map.put("EndStation",e4);
                map.put("StartTime",st4);
                map.put("EndTime",et4);
                map.put("TravelTime", tt3);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==4){
                map.put("TrainName", t4);
                map.put("TrainNo",n4);
                map.put("StartStation",s4);
                map.put("EndStation",e4);
                map.put("StartTime",st4);
                map.put("EndTime",et4);
                map.put("TravelTime", tt4);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==5){
                map.put("TrainName", t5);
                map.put("TrainNo",n5);
                map.put("StartStation",s5);
                map.put("EndStation",e5);
                map.put("StartTime",st5);
                map.put("EndTime",et5);
                map.put("TravelTime", tt5);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==6){
                map.put("TrainName", t6);
                map.put("TrainNo",n6);
                map.put("StartStation",s6);
                map.put("EndStation",e6);
                map.put("StartTime",st6);
                map.put("EndTime",et6);
                map.put("TravelTime", tt6);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==7){
                map.put("TrainName", t1);
                map.put("TrainNo",n1);
                map.put("StartStation",s1);
                map.put("EndStation",e1);
                map.put("StartTime",st1);
                map.put("EndTime",et1);
                map.put("TravelTime", tt1);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==8){
                map.put("TrainName", t2);
                map.put("TrainNo",n2);
                map.put("StartStation",s2);
                map.put("EndStation",e2);
                map.put("StartTime",st2);
                map.put("EndTime",et2);
                map.put("TravelTime", tt2);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==9){
                map.put("TrainName", t3);
                map.put("TrainNo",n3);
                map.put("StartStation",s3);
                map.put("EndStation",e3);
                map.put("StartTime",st3);
                map.put("EndTime",et3);
                map.put("TravelTime", tt3);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==10){
                map.put("TrainName", t4);
                map.put("TrainNo",n4);
                map.put("StartStation",s4);
                map.put("EndStation",e4);
                map.put("StartTime",st4);
                map.put("EndTime",et4);
                map.put("TravelTime", tt4);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==11){
                map.put("TrainName", t5);
                map.put("TrainNo",n5);
                map.put("StartStation",s5);
                map.put("EndStation",e5);
                map.put("StartTime",st5);
                map.put("EndTime",et5);
                map.put("TravelTime", tt5);
                hashMapsTrain.add((HashMap<String, String>) map);
            }
            if (i==12){
                map.put("TrainName", t6);
                map.put("TrainNo",n6);
                map.put("StartStation",s6);
                map.put("EndStation",e6);
                map.put("StartTime",st6);
                map.put("EndTime",et6);
                map.put("TravelTime", tt6);
                hashMapsTrain.add((HashMap<String, String>) map);
            }

            //hashMapsTrain.add((HashMap<String, String>) map);
        }

        ListAdapter adapter = new SimpleAdapter(getApplicationContext(), hashMapsTrain, R.layout.list_item,
                new String[]{"TrainName", "TrainNo", "StartStation", "EndStation","StartTime","EndTime", "TravelTime"},
                new int[]{R.id.tv_tname, R.id.tv_trainNo, R.id.tv_start_station, R.id.tv_end_station, R.id.tv_start_time, R.id.tv_end_time, R.id.tv_travel_time}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                /*CardView cardView = findViewById(R.id.card_view1);
                if (position %2 ==1){
                    cardView.setBackgroundColor(Color.parseColor("#E0E0E0"));
                }else{
                    cardView.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }*/
                return view;
            };

        };
        lvTrain.setAdapter(adapter);

        lvTrain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, CoachActivity.class);
                startActivity(intent);


            }
        });

    }

    @SuppressLint("RestrictedApi")
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
                Intent intent = new Intent(MainActivity.this, FAQsActivity.class);
                startActivity(intent);

                return true;
            case R.id.logout:
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                CommonMethod.setPrefsData(getApplicationContext(), Constants.PREF_USERNAME, "");
                startActivity(intent1);
                finish();

            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
