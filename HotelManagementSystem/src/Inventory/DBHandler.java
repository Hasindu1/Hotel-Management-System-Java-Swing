/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vishu PC
 */
public class DBHandler {
    static Connection connection = null;
    private DBHandler(){
        
    }
     public static Connection getDBConnection(){
     try{
         if(connection == null){
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url ="jdbc:derby://localhost:1527/HotelManagement;user=root;password=root";
             connection = DriverManager.getConnection(url);
             System.out.println("Conected");
         }
         
     }catch(Exception e){
         System.out.println(e.getMessage());
     }
     
     return connection;
     }
}
