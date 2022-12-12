/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class OpenPDF {
    public static void openById(String id){
        try{
            if((new File("/Users/shreyasdasariicloud.com/Desktop/'"+id+"'.pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler /Users/shreyasdasariicloud.com/Desktop/'"+id+"'.pdf");
            }
            else
                JOptionPane.showMessageDialog(null, "Ticket PDF has been generated!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
