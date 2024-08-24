package com.res;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class MyDatabase{
    public static Connection myConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database conncect succesfully");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67","root","root");
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static List<Student> StudentRowMapper(ResultSet rs) throws SQLException{
        List<Student> list = new ArrayList<>();
        while(rs.next()){
            Student s = new Student();
            s.setStu_id(rs.getInt("sid"));
            s.setStu_name(rs.getString("sname"));
            s.setStu_city(rs.getString("scity"));
            s.setStu_percentage(rs.getDouble("percentage"));
            list.add(s);
        }
        rs.close();
        return list;
    }
}