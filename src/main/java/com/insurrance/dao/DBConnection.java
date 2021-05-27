package com.insurrance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	private static Connection con = null;
    public static Connection getConnection(){
        String dbUrl = "jdbc:mysql://localhost:3306/bhyt?useUnicode=true&characterEncoding=UTF-8";
        String dbUser = "root";
        String dbPassword = "Cuongict12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    public static void closeConnection(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
