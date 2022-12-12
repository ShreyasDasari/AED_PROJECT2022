/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Flight;
import java.sql.*;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class FlightDb {
    
    public static void save(Flight flightName,Flight flightNo,Flight source, Flight destination){
        String query = "insert into flight(flightname,flightno,source,destination) values('"+flightName.getFlightName()+"','"+flightNo.getFlightNo()+"','"+source.getSource()+"','"+destination.getDestination()+"') ";
        DbOperations.setDataorDelete(query, "Flight Added Successfully");
    }
    
    public static ArrayList<Flight> getallRecords(){
        ArrayList<Flight> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from flight");
            while(rs.next()){
                Flight flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightNo(rs.getString("flightNo"));
                flight.setSource(rs.getString("source"));
                flight.setDestination(rs.getString("destination"));
                arraylist.add(flight);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
        
    }
    
    public static void delete(String id){
        String query = "delete from flight where id='"+id+"'";
        DbOperations.setDataorDelete(query, "Flight deleted Successfully!");
    }
    
}
