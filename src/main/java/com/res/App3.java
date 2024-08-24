package com.res;

import java.util.List;
import java.util.Map;

public class App3 {
    public static void main(String[] args) {
        StudentDemo sd = new StudentDemo();
        Student s2 = new Student();
        s2.setStu_name("Gunther");
        s2.setStu_city("LA");
        sd.updateStudetDetailById(6);
        Map<String,List> m = sd.findEnameAndSalary();
        for (int i = 0; i < m.get("listOfNames").size(); i++) {
            System.out.println(m.get("listOfNames").get(i)+"\t\t"+m.get("listOfSalary").get(i));
        }
        // sd.deleteStudentDetails(2);
        // System.out.println(sd.getAllStudentDetails());
        // System.out.println(sd.findStudentById(50));
    }
}
