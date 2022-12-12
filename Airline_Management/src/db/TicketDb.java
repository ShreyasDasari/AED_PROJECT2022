/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.mysql.cj.protocol.Resultset;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Ticket;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class TicketDb {
    public static String getID(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from ticket");
            if(rs.next()){
                id = rs.getInt(1);
                id = id + 1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Ticket ticket){
        String query = "insert into ticket values('"+ticket.getId()+"','"+ticket.getName()+"','"+ticket.getMobileno()+"','"+ticket.getEmail()+"','"+ticket.getDate()+"','"+ticket.getTotal()+"','"+ticket.getCreatedBy()+"','"+ticket.getSource()+"','"+ticket.getDestination()+"')";
        DbOperations.setDataorDelete(query, "Ticket has been generated");
    }
    
    public static ArrayList<Ticket> getAllRecordsByInc(String date){
        ArrayList<Ticket> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from ticket where date like '%"+date+"%'");
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setName(rs.getString("name"));
                ticket.setMobileno(rs.getString("mobileno"));
                ticket.setEmail(rs.getString("email"));
                ticket.setDate(rs.getString("date"));
                ticket.setTotal(rs.getString("total"));
                ticket.setCreatedBy(rs.getString("createdBy"));
                ticket.setSource(rs.getString("source"));
                ticket.setDestination(rs.getString("destination"));
                arrayList.add(ticket);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Ticket> getAllRecordsByDesc(String date){
        ArrayList<Ticket> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from ticket where date like '%"+date+"%' order By id DESC");
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setName(rs.getString("name"));
                ticket.setMobileno(rs.getString("mobileno"));
                ticket.setEmail(rs.getString("email"));
                ticket.setDate(rs.getString("date"));
                ticket.setTotal(rs.getString("total"));
                ticket.setCreatedBy(rs.getString("createdBy"));
                ticket.setSource(rs.getString("source"));
                ticket.setDestination(rs.getString("destination"));
                arrayList.add(ticket);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
}
