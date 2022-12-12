/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import javax.swing.JOptionPane;

/**
 *
 * @author shreyasdasariicloud.com
 */
public class Tables {
    public static void main(String[] args){
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileno varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE (email))";
            String adminDetails = "insert into user(name,email,mobileno,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','US','admin','What is your favourite team?','ABC','true')";
            String flightTable = "alter table flight(id int AUTO_INCREMENT primary key,flightname varchar(200),flightno varchar(5),source varchar(20),destination varchar(20))";
            String flightDetails = "create table flightdetails(id int AUTO_INCREMENT primary key,flightname varchar(200),flightno varchar(5),price varchar(200))";
            DbOperations.setDataorDelete(userTable, "User Table created Successfully");
            DbOperations.setDataorDelete(adminDetails, "Admin Details Added Successfully");
            DbOperations.setDataorDelete(flightTable, "Flight Table created Successfully");
            DbOperations.setDataorDelete(flightDetails, "FlightDetails Table created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
}
