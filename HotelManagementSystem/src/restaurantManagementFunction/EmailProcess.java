/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantManagementFunction;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Hasindu
 */
public class EmailProcess implements Runnable{
    
 
String text1,text2,text3,userEmail;
    public EmailProcess(String text1,String text2,String text3,String userEmail) {
      this.text1 = text1;
      this.text2 =text2;
      this.text3 = text3;
      this.userEmail = userEmail;
    }

    public void run() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("hkabalana@gmail.com", "hasindu123");

            }

        });

        try {

            //Creating a Message object to set the email content

            MimeMessage msg = new MimeMessage(session);

            //Storing the comma seperated values to email addresses

//            String to = "hasiyadahanayake@gmail.com,hasindudahanayake1998@gmail.com";
String to =userEmail;

            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email

            addresses in an array of InternetAddress objects*/

            InternetAddress[] address = InternetAddress.parse(to, true);

            //Setting the recepients from the address variable

            msg.setRecipients(Message.RecipientType.TO, address);

            //String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());

            msg.setSubject("Hotel KABALANA Restaurant Payement");

            msg.setSentDate(new Date());
            String s1 = "Hasindu";
            String s2 ="Dahanaykae";
            

            msg.setText(text1  +"                         "  + "                   "+text2+"                 "+text3 );

            msg.setHeader("XPriority", "1");

            Transport.send(msg);

            System.out.println("Mail has been sent successfully");

        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }
    }
}
