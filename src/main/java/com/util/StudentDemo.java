package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public int insertStudentData(Student s){
        int check =0;
        Connection con = MyDatabase.myConnection();
        String sql = "insert into student1(sname,scity,percentage)values(?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getSname());
            pst.setString(2,s.getScity());
            pst.setDouble(3,s.getPercentage());
            check = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{MyDatabase.closeConnection(pst, con);}
        return check;
    }
    public int deleteStudentDate(int sid){
        int check = 0;
        Connection con = MyDatabase.myConnection();
        String sql = "delete from Student1 where sid=?";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sid);
            check= pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{MyDatabase.closeConnection(pst, con);}
        return check;
    }
    public Student findStudentById(int sid){
        Student s = null;
        Connection con = MyDatabase.myConnection();
        PreparedStatement pst = null;
        String sql = "select * from student1 where sid=?";
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, sid);
            rs = pst.executeQuery();
            while (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setScity(rs.getString("scity"));
                s.setPercentage(rs.getDouble("percentage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            MyDatabase.closeConnection(rs, pst, con);
        }
        return s;
    }
    public List<Student> FindAllStudent(){
        List<Student> stu = new ArrayList<>();
        Connection con = MyDatabase.myConnection();
        PreparedStatement pst = null;
        String sql = "Select * from student1";
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setScity(rs.getString("scity"));
                s.setPercentage(rs.getDouble("percentage"));
                stu.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{MyDatabase.closeConnection(rs, pst, con);}
        return  stu;
    }
}
