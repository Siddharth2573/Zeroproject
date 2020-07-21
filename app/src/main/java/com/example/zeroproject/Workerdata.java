package com.example.zeroproject;

public class Workerdata {
   private String Wname,Wmobile,Wwork,Wlocation;

    public Workerdata(){

    }

    public Workerdata(String Wname,String Wmobile,String Wwork,String Wlocation) {
        this.Wname = Wname;
        this.Wmobile = Wmobile;
        this.Wwork = Wwork;
        this.Wlocation = Wlocation;
    }

    public String getWname() {
        return Wname;
    }

    public String getWmobile() {
        return Wmobile;
    }

    public String getWwork() {
        return Wwork;
    }

    public String getWlocation() {
        return Wlocation;
    }
}
