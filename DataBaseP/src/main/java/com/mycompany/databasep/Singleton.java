/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databasep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author baraa
 */
public class Singleton {
    private static Singleton instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3307/greenthumb";
    private String username = ""; 
    private String password = ""; 
    
    private Singleton() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection creation failed: " + e.getMessage());
        }
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
     public Connection getConnection() {
        return connection;
    }
     
}

