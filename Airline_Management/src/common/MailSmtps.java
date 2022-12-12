/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import db.UserDb;
import java.util.ArrayList;
import airline_management.SignupJFrame;
import model.User;
        

/**
 *
 * @author shreyasdasariicloud.com
 */
public class MailSmtps {
    
   public static void MailSmtps(User user) {
       String email = null;
       
      // Recipient's email ID needs to be mentioned.
       String to = user.getEmail();//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "alphaairlines07";//change accordingly
      final String username = "alphaairlines07";//change accordingly
      final String password = "hijkfeyqfgsspvac";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Welcome To Alpha Airlines");

         // Now set the actual message
         message.setText("Thankyou for registering with our airlines. "
            + "We look forward to serve you at our best :) ");

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}
    
