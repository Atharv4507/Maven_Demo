package com.model;

public class Student {
    private int sid;
    private String sname;
    private String scity;
    private double percentage;
    public void setId(int sid){
        this.sid = sid;
    }
    public int getId(){
        return sid;
    }
    public String getSname() {
        return sname;
    }
    public String getScity() {
        return scity;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public void setScity(String scity) {
        this.scity = scity;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
}
