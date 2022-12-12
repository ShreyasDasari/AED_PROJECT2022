/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class UserDb {
    public static void save(User user){
        String query = "insert into user(name, email, mobileno, address, password, securityQuestion, answer, status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileno()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataorDelete(query, "Registered Successfully! Wait for Admin Approval");
        
    }
    
    public static User login(String email, String password){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("select * from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("select * from user where email = '" + email + "' ");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email, String newPassword){
        String query = "Update user set password = '" + newPassword + "' where email = '" + email + "'";
        DbOperations.setDataorDelete(query, "Password changed Successfully");
    }
    
}
