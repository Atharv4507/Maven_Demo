package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDemo {

    public int insertStudent(Student stu){
        int check = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "root");
            String sql2 = "insert into student(sname,scity,percentage) values(?,?,?)";
            pst = con.prepareStatement(sql2);
            pst.setString(1,stu.getSname());
            pst.setString(2,stu.getScity());
            pst.setDouble(3,stu.getPercentage());
            check = pst.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }
    public int deleteStudent(int sid){
        int check = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67", "root", "root");
            String sql3 = "delete from student where sid=?";
            pst = con.prepareStatement(sql3);
            pst.setInt(1,sid);
            check = pst.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
                pst.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return check;
    }
}