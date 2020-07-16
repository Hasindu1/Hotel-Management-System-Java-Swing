/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIChanges;

import java.awt.Color;
import javax.swing.JPanel;



/**
 *
 * @author Hasindu Yahampath Dias Dahanayake
 */
public class NavigationColour {
    public void mouseEntered(JPanel jPanel){
        jPanel.setBackground(new Color(85,68,118));
        
               
    }
    public void mouseExsited(JPanel jPanel){
        jPanel.setBackground(new Color(54,33,89));
    }
    public void mousePressed(JPanel jPanel,JPanel jPanel1,JPanel jPanel2,JPanel jPanel3,JPanel jPanel4,JPanel jPanel5){
        jPanel1 = null;
        jPanel2 = null;
        jPanel3 = null;
        jPanel4=null;
        jPanel5 = null;
        
        jPanel.setBackground(new Color(85,68,118));
        if(!(jPanel1==null)){
             jPanel1.setBackground(new Color(54,33,89)); 
        }
        if(!(jPanel2==null)){
             jPanel2.setBackground(new Color(54,33,89)); 
        }
        if(!(jPanel3==null)){
             jPanel3.setBackground(new Color(54,33,89)); 
        }
        if(!(jPanel4==null)){
             jPanel4.setBackground(new Color(54,33,89)); 
        }
        if(!(jPanel5==null)){
             jPanel5.setBackground(new Color(54,33,89)); 
        }
        
        
    }
    
    
}
