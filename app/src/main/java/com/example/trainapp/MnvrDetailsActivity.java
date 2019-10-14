package com.example.trainapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MnvrDetailsActivity extends AppCompatActivity {

    ListView lvMNVR;
    Button btn_user_details;
    List<HashMap<String, String>> hashMapsMNVR;

    Bitmap bitmap;
    String latLng, name, address, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnvr_details);
        //get data

        byte[] bytes = getIntent().getByteArrayExtra("image");
        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        name = getIntent().getStringExtra("name");
        date = getIntent().getStringExtra("date");
        latLng = getIntent().getStringExtra("lat");
        address = getIntent().getStringExtra("add");

        hashMapsMNVR = new ArrayList<>();

        btn_user_details = findViewById(R.id.btn_user);
        btn_user_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MnvrDetailsActivity.this, UserManualsActivity.class);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] bytes = byteArrayOutputStream.toByteArray();

                intent.putExtra("name", "sonu");
                intent.putExtra("lat", ""+latLng);
                intent.putExtra("date", date);
                intent.putExtra("add", address);
                intent.putExtra("image", bytes);
                startActivity(intent);
            }
        });

        lvMNVR = findViewById(R.id.lvMNVR);
        GetMnvrDetails();

    }

    public void GetMnvrDetails(){
        for (int i = 0; i<15; i++){

            String Camera1 = "Camera1";
            String Camera = "Camera1";
            String Status1 = "OFF";
            String Status = "ON";

            Map<String, String> map = new LinkedHashMap<>();

            if (i == 1){
                map.put("Camera", Camera+i);
                map.put("Status", Status1);
                hashMapsMNVR.add((HashMap<String, String>) map);
            }else {
                map.put("Camera", Camera+i);
                map.put("Status", Status);
                hashMapsMNVR.add((HashMap<String, String>) map);
            }


        }

        ListAdapter adapter = new SimpleAdapter(getApplicationContext(), hashMapsMNVR, R.layout.mnvr_list,
                new String[]{"Camera", "Status"},
                new int[]{R.id.tv_camera, R.id.tv_status}){
          @Override
          public View getView(int position, View contentView, ViewGroup parent){
              View view = super.getView(position, contentView, parent);
              /*if (position % 2 ==1){
                  view.setBackgroundColor(Color.parseColor("#E0E0E0"));
              }else{
                  view.setBackgroundColor(Color.parseColor("#FAFAFA"));
              }*/
              return view;
          }
        };
        lvMNVR.setAdapter(adapter);

        lvMNVR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openDialog();
            }
        });
    }

    public void openDialog() {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        TextView title = new TextView(this);
        title.setText("");
        title.setGravity(Gravity.CENTER);
        alertDialog.setCustomTitle(title);

        // Set Message
        TextView msg = new TextView(this);
        // Message Properties
        msg.setText("Hard Disk Available Space: 500 GB.\n BandWidth Usage: 200 Mbps");
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        msg.setTextSize(14);
        alertDialog.setView(msg);


        // Set Button
        // you can more buttons
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });

        new Dialog(getApplicationContext());
        alertDialog.show();

       /* // Set Properties for OK Button
        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        okBT.setPadding(50, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);

        final Button cancelBT = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams negBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        negBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        cancelBT.setTextColor(Color.RED);
        cancelBT.setLayoutParams(negBtnLP);*/
    }

    // menu options
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
                Intent intent = new Intent(MnvrDetailsActivity.this, FAQsActivity.class);
                startActivity(intent);

                return true;

            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
