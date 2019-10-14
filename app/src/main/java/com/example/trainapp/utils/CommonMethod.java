package com.example.trainapp.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

public final class CommonMethod {

    public static void setPrefsData(Context context, String prefKey, String prefValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(prefKey, prefValue);
        editor.apply();
    }

    public static String getPrefsData(Context context, String prefKey, String defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefValue = sharedPreferences.getString(prefKey, defaultValue);
        return prefValue;
    }

    //** called for checking Internet connection

    public static boolean isOnline(Context context){
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //check for network connections
        assert connect!= null;
        if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
            connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
            connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
            connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED){
            return true;
        }else if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
        connect.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED){
            return false;
        }
        return false;
    }

    public static  void showNetworkErrorMessage(String Title, String Message, final Activity context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(Message).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        context.finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.setTitle(Title);

        if (!context.isFinishing()){
            dialog.show();
        }
    }
}
