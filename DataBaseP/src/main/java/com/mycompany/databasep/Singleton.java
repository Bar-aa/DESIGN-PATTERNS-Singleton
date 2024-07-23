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
/**
 * The Singleton class manages a single instance of a database connection.
 * It ensures that only one instance of the connection exists throughout
 * the application.
 * 
 * Singleton pattern requires special treatment in a multithreaded environment 
 * so that multiple threads won’t create a singleton object several times.
 * and this cod can handle this case
 * 
 */
public class Singleton {
    private static Singleton instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/greenthumb";
    //private String username = ""; 
    //private String password = ""; 
    
    /**
    * Private constructor to prevent instantiation from outside.
    * Initializes the database connection.
    */
    private Singleton() {
        try {
            this.connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Database connection creation failed: " + e.getMessage());
        }
    }
    /**
    * Provides the new instance of the Singleton class
    * if it is created for the first time 
    * or if it was created previously 
    * 
    * @return the Singleton instance
    */
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
    /**
    * Retrieves the database connection.
    * 
    * @return the database connection
    */
     public Connection getConnection() {
        return connection;
    }
     
}

