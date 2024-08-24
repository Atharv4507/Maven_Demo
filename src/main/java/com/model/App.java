package com.model;

public class App {
    public static void main(String[] args) {
        StudentDemo sd = new StudentDemo();
        Student s1 = new Student();
        s1.setSname("Babli");
        s1.setScity("solapur");
        s1.setPercentage(72.87);
        // System.out.println(sd.insertStudent(s1));
        System.out.println(sd.deleteStudent(2));
        
    }
}
