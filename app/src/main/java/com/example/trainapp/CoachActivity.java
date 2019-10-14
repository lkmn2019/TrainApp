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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CoachActivity extends AppCompatActivity {

    List<HashMap<String, String>> hashMapsCoach;
    ListView lvCoach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);

        hashMapsCoach = new ArrayList<>();
        lvCoach = findViewById(R.id.lv_coach);
        GetCoachDetails();
    }

    public void GetCoachDetails() {

            Map<String, String> map = new LinkedHashMap<>();
            Map<String, String> map1 = new LinkedHashMap<>();
            Map<String, String> map2 = new LinkedHashMap<>();
            Map<String, String> map3 = new LinkedHashMap<>();

            map.put("CoachNo", "A1");
            map.put("CoachType", "AC Tier 1");
            map.put("Fare", "3200");
            hashMapsCoach.add((HashMap<String, String>) map);

            map1.put("CoachNo", "A2");
            map1.put("CoachType", "AC Tier 2");
            map1.put("Fare", "2200");
            hashMapsCoach.add((HashMap<String, String>) map1);

            map2.put("CoachNo", "A3");
            map2.put("CoachType", "AC Tier 3");
            map2.put("Fare", "1600");
            hashMapsCoach.add((HashMap<String, String>) map2);

            map3.put("CoachNo", "SL");
            map3.put("CoachType", "Sleeper Class");
            map3.put("Fare", "850");
            hashMapsCoach.add((HashMap<String, String>) map3);



        ListAdapter adapter = new SimpleAdapter(getApplicationContext(), hashMapsCoach, R.layout.coach_list_item,
                new String[]{"CoachNo", "CoachType", "Fare"},
                new int[]{R.id.tv_coach_no, R.id.tv_coach_type, R.id.tv_fare}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                /*if (position %2 ==1){
                    view.setBackgroundColor(Color.parseColor("#E0E0E0"));
                }else{
                    view.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }*/
                return view;
            }
        };
        lvCoach.setAdapter(adapter);

        lvCoach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CoachActivity.this, NetworkCheckActivity.class);
                startActivity(intent);


            }
        });
    }
// support menu item and faq description
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
                Intent intent = new Intent(CoachActivity.this, FAQsActivity.class);
                startActivity(intent);

                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }


}
