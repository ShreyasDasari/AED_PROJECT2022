/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.ArrayList;
import model.FlightDetails;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class FlightDetailsDb {

    public static void save(FlightDetails flightDetails) {
        String query = "insert into flightDetails(flightname, flightno, price) values('" + flightDetails.getFlightName() + "','" + flightDetails.getFlightNo() + "','" + flightDetails.getPrice() + "')";
        DbOperations.setDataorDelete(query, "Flight Details Added Successfully");
    }

    public static ArrayList<FlightDetails> getAllRecords() {
        ArrayList<FlightDetails> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from flightdetails");
            while (rs.next()) {
                FlightDetails flightDetails = new FlightDetails();
                flightDetails.setId(rs.getInt("id"));
                flightDetails.setFlightName(rs.getString("flightname"));
                flightDetails.setFlightNo(rs.getString("flightno"));
                flightDetails.setPrice(rs.getString("price"));
                arrayList.add(flightDetails);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void update(FlightDetails flightDetails) {
        String query = "update flightDetails set flightname = '" + flightDetails.getFlightName() + "',flightno = '" + flightDetails.getFlightNo() + "',price = '" + flightDetails.getPrice() + "' where id = '" + flightDetails.getId() + "'";
        DbOperations.setDataorDelete(query, "Flight Details Updated!");
    }

    public static void delete(String id) {
        String query = "delete from flightDetails where id = '" + id + "'";
        DbOperations.setDataorDelete(query, "Product Deleted!");
    }

    public static ArrayList<FlightDetails> getAllRecordsByCategory(String flightName) {
        ArrayList<FlightDetails> arrayList = new ArrayList();
        try {
            ResultSet rs = DbOperations.getData("select * from flightdetails where flightname='"+flightName+"'");
            while (rs.next()) {
                FlightDetails flightDetails = new FlightDetails();
                flightDetails.setFlightName(flightName);
                arrayList.add(flightDetails);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<FlightDetails> filterFlightDetailsByName(String flightNo,String flightName){
        ArrayList<FlightDetails> arrayList = new ArrayList();
        try{
            ResultSet rs = DbOperations.getData("select * from flightdetails where flightNo like '%"+flightNo+"%' and flightname='"+flightName+"'");
            while(rs.next()){
                FlightDetails flightDetails = new FlightDetails();
                flightDetails.setFlightName(flightName);
                arrayList.add(flightDetails);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static FlightDetails getFlightDetailsByName(String flightName){
        FlightDetails flightDetails = new FlightDetails();
        try{
            ResultSet rs = DbOperations.getData("select * from flightdetails where flightname='"+flightName+"'");
            while(rs.next()){
                flightDetails.setFlightName(rs.getString(2));
                flightDetails.setFlightNo(rs.getString(3));
                flightDetails.setPrice(rs.getString(4));
                
            }
        }
        catch(Exception e){    
            JOptionPane.showMessageDialog(null, e);
        }
        return flightDetails;
    }
}
