/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Enterprise;


/**
 *
 * @author shreyasdasariicloud.com
 */
public class EnterpriseDb {
    
    public static Enterprise login(String name, String password) {
        Enterprise enterprise = null;
        try {
            ResultSet rs = DbOperations.getData("select * from enterprise where name='" + name + "' and password='" + password + "'");
            while (rs.next()) {
                enterprise = new Enterprise();
                enterprise.setName(rs.getString("name"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return enterprise;
    }
    
}
