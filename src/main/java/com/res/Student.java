package com.res;

public class Student {
    private int stu_id;
    private String stu_name;
    private String stu_city;
    private double stu_percentage;
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
    public void setStu_city(String stu_city) {
        this.stu_city = stu_city;
    }
    public void setStu_percentage(double stu_percentage) {
        this.stu_percentage = stu_percentage;
    }
    public int getStu_id() {
        return stu_id;
    }
    public String getStu_name() {
        return stu_name;
    }
    public String getStu_city() {
        return stu_city;
    }
    public double getStu_percentage() {
        return stu_percentage;
    }
    public String toString(){
        return "    Student_Id:"+stu_id+
               ",   Student_Name:"+stu_name+
               ",   Student_City:"+stu_city+
               ",   Student_Percentage:"+stu_percentage+"%\n";
    }
}

