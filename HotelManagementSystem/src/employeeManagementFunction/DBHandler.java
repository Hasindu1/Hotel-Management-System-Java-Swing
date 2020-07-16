/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeManagementFunction;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Manthi
 */
public class DBHandler {
     static Connection connection = null;
    private DBHandler(){
    }   
    
    public static Connection getDBConnection(){
        try{
            if(connection == null){
                Class.forName("java.sql.DriverManager");
                 String url = "jdbc:derby://localhost:1527/HotelManagement;user=root; password=root";
                 connection = DriverManager.getConnection(url);
                 System.out.println("Connected!");
                
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    
    
}
