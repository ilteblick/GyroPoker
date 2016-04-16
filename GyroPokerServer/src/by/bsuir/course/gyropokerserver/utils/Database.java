/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerserver.utils;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class Database {
    public synchronized static Connection getConnection(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/gyropokerdb", "root", "qwerty");
            return con;
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not founded");
        } catch (SQLException ex) {
            System.err.println("Database.getConnection() err " + ex.getMessage());
        }
        return null;
    }
    
    
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println("Bad close connection");
        }
    }
}
