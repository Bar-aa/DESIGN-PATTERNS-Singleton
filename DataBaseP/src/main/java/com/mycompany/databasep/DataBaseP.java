/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.databasep;
import java.sql.Connection;

/**
 *
 * @author baraa
 */
public class DataBaseP {

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
        
    }
}
