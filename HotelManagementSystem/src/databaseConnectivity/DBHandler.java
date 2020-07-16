/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnectivity;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kavee
 */
public class DBHandler {
     static Connection connection = null;
    private DBHandler(){
    }   
    
    public static Connection getDBConnection(){
        try{
            if(connection == null){
                String currentDir = System.getProperty("user.dir");
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
               // String databaseURL = "jdbc:derby:/d:/projects/booksdb;create=true";
                // String url = "jdbc:derby://localhost:1527/HotelManagement;user=root; password=root";
                 String url="jdbc:derby:C:\\Users\\Hasindu\\AppData\\Roaming\\NetBeans\\Derby\\HotelManagement;create=true";
                 
                // connection = DriverManager.getConnection(url,"root","root");
                      connection = DriverManager.getConnection("jdbc:derby:"+currentDir+"\\HotelManagement;create=true","root","root");
                 System.out.println("Connected!");
                
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    
    
}
