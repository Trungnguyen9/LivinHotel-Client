/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cung cấp kết nối đến cơ sở dữ liệu MySQL.
 */
public class ConnectionProvider {
    private static final String URL = "jdbc:mysql://192.168.1.15:3306/hotel";  // Địa chỉ IP máy chủ
    private static final String USER = "remote_user";
    private static final String PASSWORD = "password";

    public static Connection getCon() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection and return it
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return null;
        }
    }
}
