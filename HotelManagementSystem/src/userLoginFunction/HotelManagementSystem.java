/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userLoginFunction;

/**
 *
 * @author Hasindu
 */
public class HotelManagementSystem {
    public static void main(String[] args) {
         SplashView splashView = new SplashView();
           splashView.setVisible(true);
           Login login = new Login();
           int i =0;
           try{
               for(i =0 ; i<=100 ; i++){
                   Thread.sleep(40);
                   splashView.setValueJLabel3(i);
                   splashView.setValueJProgressBar1(i);
                     if(i ==100){
                   
                   //splashView.dispose();
                   
                  login.setSpalshView(splashView);
                   login.setVisible(true);
                  
               }
               }
             
           }catch(Exception e){
               e.printStackTrace();
           }
    }
   
    
    
    
}

