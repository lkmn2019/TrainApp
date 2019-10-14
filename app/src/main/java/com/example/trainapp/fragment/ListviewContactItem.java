package com.example.trainapp.fragment;

public class ListviewContactItem {

    private String MNVR_P_ID;
    private String Current_Coach_ID;
    private String POWER;
    private String WIFI;

    public String getMNVR_P_ID(){
        return MNVR_P_ID;
    }

    public String getCurrent_Coach_ID() {
        return Current_Coach_ID;
    }

    public String getPOWER() {
        return POWER;
    }

    public String getWIFI() {
        return WIFI;
    }

    public void setMNVR_P_ID(String MNVR_P_ID) {
        this.MNVR_P_ID = MNVR_P_ID;
    }

    public void setCurrent_Coach_ID(String current_Coach_ID) {
        Current_Coach_ID = current_Coach_ID;
    }

    public void setPOWER(String POWER) {
        this.POWER = POWER;
    }

    public void setWIFI(String WIFI) {
        this.WIFI = WIFI;
    }
}
