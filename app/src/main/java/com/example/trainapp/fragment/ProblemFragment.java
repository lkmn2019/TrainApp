package com.example.trainapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.trainapp.CoachActivity;
import com.example.trainapp.FAQsActivity;
import com.example.trainapp.LoginActivity;
import com.example.trainapp.R;
import com.example.trainapp.WifiActivity;
import com.example.trainapp.utils.CommonMethod;
import com.example.trainapp.utils.Constants;

import java.util.ArrayList;


public class ProblemFragment extends Fragment {
    ListView listView;

    public ProblemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_problem, container, false);
        ArrayList<ListviewContactItem> listContact = GetlistContact();
        listView = (ListView)rootView.findViewById(R.id.lvNetwork);
        listView.setAdapter(new ListviewContactAdapter(getActivity(),listContact));

        //menu item
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void onStart(){
        super.onStart();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WifiActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<ListviewContactItem>GetlistContact(){
        ArrayList<ListviewContactItem > contactList = new ArrayList<ListviewContactItem >();
        ListviewContactItem contactItem = new ListviewContactItem();

        contactItem.setMNVR_P_ID("ABC1230101");
        contactItem.setCurrent_Coach_ID("01213113568");
        contactItem.setPOWER("On");
        contactItem.setWIFI("01213113568");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC1230201");
        contactItem.setCurrent_Coach_ID("012131-A1-568");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("01213113568");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC1230112");
        contactItem.setCurrent_Coach_ID("012131-B1-521");
        contactItem.setPOWER("On");
        contactItem.setWIFI("01213113568");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC12301052");
        contactItem.setCurrent_Coach_ID("012131-B2-1356");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC12301014");
        contactItem.setCurrent_Coach_ID("012131-B3-552");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC12301030");
        contactItem.setCurrent_Coach_ID("012131-S1-541");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC12301017");
        contactItem.setCurrent_Coach_ID("012131-S3-468");
        contactItem.setPOWER("ON");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC123010368");
        contactItem.setCurrent_Coach_ID("012131-S13-128");
        contactItem.setPOWER("ON");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC123010203");
        contactItem.setCurrent_Coach_ID("012131-S11-368");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("01213113568");
        contactList.add(contactItem);

        contactItem.setMNVR_P_ID("ABC12301075");
        contactItem.setCurrent_Coach_ID("012131-S15-368");
        contactItem.setPOWER("OFF");
        contactItem.setWIFI("OFF");
        contactList.add(contactItem);



        return contactList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                Intent i = new Intent(getActivity(), LoginActivity.class);
                CommonMethod.setPrefsData(getActivity(), Constants.PREF_USERNAME, "");
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

                return true;
            case R.id.faq:
                Intent intent = new Intent(getActivity(), FAQsActivity.class);
                startActivity(intent);
                return true;
            case R.id.support:
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

}
