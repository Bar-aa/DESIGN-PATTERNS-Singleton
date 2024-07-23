/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.databasep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This is the main class where we can Testing the use 
 * and accuracy of implementation of the Singleton pattern 
 * Note: The database used in this application is for a project
 * for my university.
 * @author baraa
 */
public class DataBaseP {
     /**
     * The main method to run the database application.
     * It tests the Singleton implementation by creating
     * multiple instances and checking if they are the same.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // Get the singleton instance multiple times
        Singleton dbInstance1 = Singleton.getInstance();
        Singleton dbInstance2 = Singleton.getInstance();
        
        // Test if the instances are the same
        if (dbInstance1 == dbInstance2) {
            System.out.println("Singleton works: Both instances are the same.");
        } else {
            System.out.println("Singleton failed: Instances are different.");
        }

        // Check if the connection is the same
        Connection conn1 = dbInstance1.getConnection();
        Connection conn2 = dbInstance2.getConnection();

        if (conn1 == conn2) {
            System.out.println("Singleton works: Both connections are the same.");
        } else {
            System.out.println("Singleton failed: Connections are different.");
        }
        
        /*// Use the connection to query the database
        try {
            Statement stmt = conn1.createStatement();
            String query = "SELECT * FROM gardens";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the result set
                System.out.println("Column 1: " + rs.getString("garden_id"));
                System.out.println("Column 2: " + rs.getString("name"));
                // ... and so on for other columns
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    }
}
