package com.res;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDemo {
    public void insertStudent(Student s){
        String sql = "insert into Mystudents(sname,scity,percentage) values(?,?,?)";
        try(
            Connection con =MyDatabase.myConnection(); 
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setString(1, s.getStu_name());
            pst.setString(2, s.getStu_city());
            pst.setDouble(3, s.getStu_percentage());
            pst.executeUpdate();
            System.out.println("Data Inserted Sucessfully");
        }catch(SQLException e){ e.printStackTrace();}
    }
    public void deleteStudentDetails(int sid){
        String sql = "delete from mystudents where sid=?";
        try(
            Connection con = MyDatabase.myConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setInt(1,sid);
            pst.executeUpdate();
            System.out.println("Data of Student have Student id "+sid+" is deleted Sucessfully");
        }catch(SQLException e){ e.printStackTrace();}
    }
    public List<Student> getAllStudentDetails(){
        List<Student> stu = new ArrayList<>();
        String sql = "Select * from myStudents";
        try(
            Connection con = MyDatabase.myConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
        ){
            stu = MyDatabase.StudentRowMapper(rs);
            System.out.println("Students Detail: ");
        }catch(SQLException e){e.printStackTrace();}
        return stu;
    }
    public Student findStudentById(int sid){
        Student s = null;
        String sql = "select * from mystudents where sid=?";
        try(
            Connection con = MyDatabase.myConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setInt(1, sid);
            ResultSet rs= pst.executeQuery();
            List<Student> list = MyDatabase.StudentRowMapper(rs);
            if(!list.isEmpty())
                s = list.get(0);
        }catch(SQLException e){e.printStackTrace();}
        return s;
    }
    public void updateStudetDetailById(int sid){
        Student s = new Student();
        String sql = "update mystudents set sname=?,scity=? where sid =?";
        try(
            Connection con  =MyDatabase.myConnection();
            PreparedStatement pst = con.prepareStatement(sql);
        ){
            pst.setInt(1, sid);
            pst.setString(2, s.getStu_name());
            pst.setString(3, s.getStu_city());
            pst.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public Map<String,List> findEnameAndSalary(){
        Map<String,List> m = new HashMap<>();
        String sql = "select sname,percentage from mystudents";
        try(
            Connection con = MyDatabase.myConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(); 
        ){
            List<String> listOfNames = new ArrayList<>();
            List<Double> listOfSalary = new ArrayList<>();
            while (rs.next()) {
                listOfNames.add(rs.getString("sname"));
                listOfSalary.add(rs.getDouble("percentage"));
            }
            m.put("listOfNames",listOfNames);
            m.put("listOfSalary",listOfSalary);
        }
        catch(SQLException e ){e.printStackTrace();}
        return m;
    } 
}
