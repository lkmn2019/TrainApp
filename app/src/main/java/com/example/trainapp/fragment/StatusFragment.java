package com.example.trainapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainapp.R;
import com.example.trainapp.WifiActivity;
import com.example.trainapp.chating.RegisterActivity;

import java.util.ArrayList;


public class StatusFragment extends Fragment {
    Button btnMNVRLogin;
    TextView txtName;
    Activity context;

    public StatusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_status, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }

    public void onStart(){
        super.onStart();

        btnMNVRLogin = (Button)context.findViewById(R.id.btn_mnvr_login);
        btnMNVRLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
