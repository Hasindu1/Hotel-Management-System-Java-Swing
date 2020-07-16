/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

/**
 *
 * @author Hasindu
 */
public class NewClass {
    public static void main(String[] args) {
        String s1 ="hasindu";
        String s2="H a s i  ndu";
        
        if(s1.replaceAll(" ","").equalsIgnoreCase(s2.replaceAll(" ",""))){
            System.out.println("Equla");
        }
        else{
            System.out.println("not equal");
        }
        
    }
}
