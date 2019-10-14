package com.example.trainapp.fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trainapp.R;

import java.util.ArrayList;

public class ListviewContactAdapter extends BaseAdapter {
    private static ArrayList<ListviewContactItem> listContact;

    private LayoutInflater mInflater;

    public ListviewContactAdapter(FragmentActivity photosFragment, ArrayList<ListviewContactItem> results){
        listContact = results;
        mInflater = LayoutInflater.from(photosFragment);
    }
    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int position) {
        return listContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.net_list, null);
            holder = new ViewHolder();
            holder.txtMnvrId =(TextView) convertView.findViewById(R.id.tv_mnvr_id);
            holder.txtCoachId =(TextView) convertView.findViewById(R.id.tv_coach_id);
            holder.txtPower =(TextView) convertView.findViewById(R.id.tv_power);
            holder.txtWifi =(TextView) convertView.findViewById(R.id.tv_wifi);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.txtMnvrId.setText(listContact.get(position).getMNVR_P_ID());
        holder.txtCoachId.setText(listContact.get(position).getCurrent_Coach_ID());
        holder.txtPower.setText(listContact.get(position).getPOWER());
        holder.txtWifi.setText(listContact.get(position).getWIFI());


        return convertView;
    }

    static  class ViewHolder{
        TextView txtMnvrId;
        TextView txtCoachId;
        TextView txtPower;
        TextView txtWifi;
    }
}
