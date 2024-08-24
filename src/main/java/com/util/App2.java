package com.util;

public class App2 {
    public static void main(String[] args) {
        StudentDemo sd = new StudentDemo();
        Student s2 = new Student();
        s2.setId(3);
        s2.setSname("PhebeBuffe");
        s2.setScity("NY");
        s2.setPercentage(89.80);
        // System.out.println(sd.insertStudentData(s2));
        // System.out.println(sd.findStudentById(5));
        System.out.println(sd.FindAllStudent());
    }
}
