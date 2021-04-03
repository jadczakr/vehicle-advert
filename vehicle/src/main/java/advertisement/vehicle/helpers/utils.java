package advertisement.vehicle.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ResourceUtils;

import advertisement.vehicle.entities.Advertisement;
import advertisement.vehicle.entities.Car;
import advertisement.vehicle.service.implementation.AdvertisementServiceImpl;


@EnableScheduling
public class utils {

	
	private static AdvertisementServiceImpl advertisementServiceImpl;
	
	@Autowired
	public utils(AdvertisementServiceImpl advertisementServiceImpl)
	{
		this.advertisementServiceImpl = advertisementServiceImpl;
	}
	
	
	
	
	public static void sendActivationMail(String mail, Car tempCar) throws IOException
	{
		
			String mesg = 
					"		<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"></head><body>"
					+ "<div style='background-color:#fcfcfc;font-family:verdana;margin:auto auto;'>		\r\n" + 
					"			<p style='\r\n" + 
					"				padding-left:10px;\r\n" + 
					"				padding-right:10px;\r\n" + 
					"				padding-top:5px;	\r\n" + 
					"				padding-bottom:5px;\r\n" + 
					"				color:white;\r\n" + 
					"				background-color:red;\r\n" + 
					"				border:none;\r\n" + 
					"				border-radius:5px;\r\n" + 
					"				font-weight:bold;\r\n" + 
					"				background-color:#ff0000;\r\n" + 
					"				text-align:center;\r\n" + 
					"				font-size:16px;\r\n" + 
					"				white-space:nowrap;\r\n" + 
					"				margin-bottom:10px;\r\n" + 
					"				border-radius:5px 5px 0px 0px;\r\n" + 
					"				text-decoration:none;\r\n" + 
					"				'><a href='tanie-daily.pl' style='color:white;text-decoration:none;'>tanie-daily.pl</a>\r\n" + 
					"			</p>\r\n" + 
					"			\r\n" + 
					"		<p style='text-align:center;font-size:15px;color:black;'>\r\n" + 
					"		\r\n" + 
					"			Hej " + tempCar.getName() + ", fajnie, że jesteś!<br><br>\r\n" + 
					"			Dziękujemy za rejestrację ogłoszenia w naszym serwisie tanie-daily.pl<br>\r\n" + 
					"			\r\n" + 
					"			Aby aktywować ogłoszenie, kliknij w link zamieszczony poniżej<br>\r\n" + 
					"					<a href='localhost:8080/active/" + tempCar.getAdvertisement().getId() + "'>link</a>\r\n" + 
					"			<br><br>\r\n" + 
					"			\r\n" + 
					"			Jednocześnie informujemy, że po aktywacji ogłoszenia otrzymasz kolejną wiadomość email, zawierająca podstawową obsługę ogłoszenia.\r\n" + 
					"			\r\n" + 
					"			<br>\r\n" + 
					"			\r\n" + 
					"			Serdecznie dziękujemy za skorzystanie z naszej bezpłatnej usługi.\r\n" + 
					"			<br>\r\n" + 
					"			Dzięki Tobie jesteśmy w stanie się rozwijać!\r\n" + 
					"			<br>\r\n" + 
					"			<br>\r\n" + 
					"			\r\n" + 
					"			\r\n" + 
					"	\r\n" + 
					"		</p>\r\n" + 
					"		\r\n" + 
					"		<p style='\r\n" + 
					"		background-color:#142355;\r\n" + 
					"		white-space:nowrap;\r\n" + 
					"		padding:10px;\r\n" + 
					"		color:white;\r\n" + 
					"		font-weight:bold;\r\n" + 
					"		font-size:14px;\r\n" + 
					"		margin:auto auto;\r\n" + 
					"		text-align:center;\r\n" + 
					"		border-radius:10px;\r\n" + 
					"		border-radius:0px 0px 5px 5px;'>\r\n" + 
					"		\r\n" + 
					"		Zapraszamy do odwiedzenia naszego serwisu!\r\n" + 
					"		</p>\r\n" + 
					"\r\n" + 
					"</div>"
					+ "</body>"
					+ "</html>"
					;
					
								
		
			String to = mail;
	        // Mention the Sender's email address
	        String from = "jadczakr@edc.expert";
	        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
	        String host = "poczta.edcexpert.pl";
	        // Get system properties
	        Properties properties = System.getProperties();
	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.starttls.enable","true");
	        properties.put("mail.smtp.ssl.enable", "false");
	        properties.put("mail.smtp.auth", "true");
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(login@mail.com,password);
	            }
	        });
	        // Used to debug SMTP issues
	        session.setDebug(true);
	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);
	            // Set From: header field of the header.
	            
	            
	            message.setFrom(new InternetAddress(from));
	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            // Set Subject: header field
	            message.setSubject("Aktywacja ogłoszenia " + tempCar.getMark() + " " + tempCar.getModel());
	            
	            message.setContent(mesg, "text/html; charset=utf-8");
	            message.setText(mesg, "utf-8", "html");
     		
	            System.out.println("Wysyłam maila...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Wysyłanie maila powiodło się...");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
		    }
	

	public static void sendExpiredAdvertMail()
	{
		
			for(Advertisement tempAdvert : advertisementServiceImpl.getAdvertisementToReactive() )
			{

				String to = tempAdvert.getEmail();
		        // Mention the Sender's email address
		        String from = "jadczakr@edc.expert";
		        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
		        String host = "poczta.edcexpert.pl";
		        // Get system properties
		        Properties properties = System.getProperties();
		        // Setup mail server
		        properties.put("mail.smtp.host", host);
		        properties.put("mail.smtp.port", "587");
		        properties.put("mail.smtp.starttls.enable","true");
		        properties.put("mail.smtp.ssl.enable", "false");
		        properties.put("mail.smtp.auth", "true");
		        // Get the Session object.// and pass username and password
		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication("jadczakr@edc.expert", "Kupagnoju9(1");
		            }
		        });
		        // Used to debug SMTP issues
		        session.setDebug(true);
		        try {
		            // Create a default MimeMessage object.
		            MimeMessage message = new MimeMessage(session);
		            // Set From: header field of the header.
		            
		            
		            message.setFrom(new InternetAddress(from));
		            // Set To: header field of the header.
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            // Set Subject: header field
		            message.setSubject("Aktywacja ");
		            // Now set the actual message
		            String mesg = "<b>test</b><br> <h1>test</h1>";
		            message.setContent(mesg, "text/html; charset=utf-8");
		            message.setText(mesg, "utf-8", "html");
	     		
		            System.out.println("Wysyłam maila...");
		            // Send message
		            Transport.send(message);
		            System.out.println("Wysyłanie maila powiodło się...");
		            
		            tempAdvert.setExpData(tempAdvert.getExpData().plusMonths(1));
		            advertisementServiceImpl.saveOrUpdate(tempAdvert);
		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		        }
			    }
			    
	}
	
	
	public static void sendEmailTool(Advertisement advert)
	{
	
		
		String to = advert.getEmail();
        // Mention the Sender's email address
        String from = "jadczakr@edc.expert";
        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
        String host = "poczta.edcexpert.pl";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jadczakr@edc.expert", "Kupagnoju9(1");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            
            
            
            
            
            
            String mesg = 
					"		<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"></head><body>"
					+ "<div style='background-color:#fcfcfc;font-family:verdana;margin:auto auto;'>		\r\n" + 
					"			<p style='\r\n" + 
					"				padding-left:10px;\r\n" + 
					"				padding-right:10px;\r\n" + 
					"				padding-top:5px;	\r\n" + 
					"				padding-bottom:5px;\r\n" + 
					"				color:white;\r\n" + 
					"				background-color:red;\r\n" + 
					"				border:none;\r\n" + 
					"				border-radius:5px;\r\n" + 
					"				font-weight:bold;\r\n" + 
					"				background-color:#ff0000;\r\n" + 
					"				text-align:center;\r\n" + 
					"				font-size:16px;\r\n" + 
					"				white-space:nowrap;\r\n" + 
					"				margin-bottom:10px;\r\n" + 
					"				border-radius:5px 5px 0px 0px;\r\n" + 
					"				text-decoration:none;\r\n" + 
					"				'><a href='tanie-daily.pl' style='color:white;text-decoration:none;'>tanie-daily.pl</a>\r\n" + 
					"			</p>\r\n" + 
					"			\r\n" + 
					"		<p style='text-align:center;font-size:15px;color:black;'>\r\n" + 
					"		\r\n" + 
					"			Aktywacja przebiegła pomyślnie. Możesz już zobaczyć swoje ogłoszenie na pod adresem: ADRES<br><br>\r\n" + 
					"			Informujemy, że z poziomu Twojej skrzynki pocztowej możesz zarządzać swoim ogłoszeniem!<br>\r\n" + 
					"			\r\n" + 
					"			<button style='padding:10px;color:white;background-color:#ff0000;'>usuń</button><br>\r\n" + 
					"					<a href='localhost:8080/active/" + advert.getId() + "'>link</a>\r\n" + 
					"			<br><br>\r\n" + 
					"			\r\n" + 
					"			Jednocześnie informujemy, że po aktywacji ogłoszenia otrzymasz kolejną wiadomość email, zawierająca podstawową obsługę ogłoszenia.\r\n" + 
					"			\r\n" + 
					"			<br>\r\n" + 
					"			\r\n" + 
					"			Serdecznie dziękujemy za skorzystanie z naszej bezpłatnej usługi.\r\n" + 
					"			<br>\r\n" + 
					"			Dzięki Tobie jesteśmy w stanie się rozwijać!\r\n" + 
					"			<br>\r\n" + 
					"			<br>\r\n" + 
					"			\r\n" + 
					"			\r\n" + 
					"	\r\n" + 
					"		</p>\r\n" + 
					"		\r\n" + 
					"		<p style='\r\n" + 
					"		background-color:#142355;\r\n" + 
					"		white-space:nowrap;\r\n" + 
					"		padding:10px;\r\n" + 
					"		color:white;\r\n" + 
					"		font-weight:bold;\r\n" + 
					"		font-size:14px;\r\n" + 
					"		margin:auto auto;\r\n" + 
					"		text-align:center;\r\n" + 
					"		border-radius:10px;\r\n" + 
					"		border-radius:0px 0px 5px 5px;'>\r\n" + 
					"		\r\n" + 
					"		Zapraszamy do odwiedzenia naszego serwisu!\r\n" + 
					"		</p>\r\n" + 
					"\r\n" + 
					"</div>"
					+ "</body>"
					+ "</html>"
					;
            
            
            
            
            
            
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Zarządzaj swoim ogłoszeniem w serwisie tanie-daily.pl");
            // Now set the actual message
            
            message.setContent(mesg, "text/html; charset=utf-8");
            message.setText(mesg, "utf-8", "html");
 		
            System.out.println("Wysyłam maila...");
            // Send message
            Transport.send(message);
            System.out.println("Wysyłanie maila powiodło się...");
            
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
		
		
		
	}
	
	
	
	
	
}
