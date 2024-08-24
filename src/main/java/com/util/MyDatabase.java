package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDatabase {
    public static Connection myConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database conncect succesfully");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap67","root","root");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void closeConnection(PreparedStatement pst, Connection con){
        try {
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(ResultSet res, PreparedStatement pst, Connection con){
        try {
            res.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
