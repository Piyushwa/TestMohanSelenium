package utilities;


	
	import java.io.File;
import java.util.Properties; 
	import javax.activation.DataHandler;
	import javax.activation.DataSource;  
	import javax.activation.FileDataSource;
	import javax.mail.BodyPart; 
	import javax.mail.Message;  import javax.mail.MessagingException;
	import javax.mail.Multipart;  
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session; 
	import javax.mail.Transport;  
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeBodyPart;  
	import javax.mail.internet.MimeMessage; 
	import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import baseclass.DriverHelper; 
	public class TestClass1 extends DriverHelper {
	
	public static void sendmail() 
	
	{      // Create object of Property file  Properties props = new Properties();  
		// this will set host of server- you can change based on your requirement   
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");    
		//    // set the port of socket factory  
		props.put("mail.smtp.socketFactory.port", "465");    // set socket factory 
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    // set the authentication to true  
		props.put("mail.smtp.auth", "true");    // set the port of SMTP server  	
		props.put("mail.smtp.port", "465");    //465    // This will handle the complete authentication 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		{   
			protected PasswordAuthentication getPasswordAuthentication(){    
				return new PasswordAuthentication("Piyushwadhwa23@gmail.com", "Anita@298");   
				} 
		});
		
		try {
			
			// Create object of MimeMessage class 
			Message message = new MimeMessage(session);    // Set the from address  	
			message.setFrom(new InternetAddress("Piyushwadhwa23@gmail.com"));   
			// Set the recipient address  
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("Piyush.wadhwa@cisive.com"));   
			// Add the subject link  
			message.setSubject("Testing Status");   
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();    // Set the body of email  
			messageBodyPart1.setText("This is message body");    // Create another object to add another content  
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();    // Mention the file which you want to send 
			String filename = "C:\\Users\\piyushwadhwa\\workspace\\Levels\\TestReport\\Levels-Automaton-Report.html";    // Create data source and pass the filename 
			DataSource source = new FileDataSource(filename);    // set the handler  	
			messageBodyPart2.setDataHandler(new DataHandler(source));    // set the file  
			messageBodyPart2.setFileName(filename);    // Create object of MimeMultipart class 
			Multipart multipart = new MimeMultipart();    // add body part 1  
			multipart.addBodyPart(messageBodyPart2);    // add body part 2  	
			multipart.addBodyPart(messageBodyPart1);    // set the content  	
			message.setContent(multipart);    // finally send the email 
			Transport.send(message);   
			System.out.println("=====Email Sent=====");   
			} 
		catch (MessagingException e) {   
			throw new RuntimeException(e);    
		}
	}
	

	/*
	 * public static File getLatestFilefromDir(String dirPath){ File dir = new
	 * File(dirPath); File[] files = dir.listFiles(); if (files == null ||
	 * files.length == 0) { return null; }
	 * 
	 * File lastModifiedFile = files[0]; for (int i = 1; i < files.length; i++) { if
	 * (lastModifiedFile.lastModified() < files[i].lastModified()) {
	 * lastModifiedFile = files[i]; } } return lastModifiedFile; }
	 */
	
	public static void filetest() {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		driver = new ChromeDriver();
		
		driver.get("https://demolevels.cisive.com/Client/casePreview/12080");


	String loc_ongoingeportWOrd = "//td[contains(text(),'Candidate Name')]";
	
	String Test123 = driver.findElement(By.xpath(loc_ongoingeportWOrd)).getText();

	System.out.println(Test123);
	}
	
	
	
	public static void sendmail2() {
		
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		Properties props = new Properties();
		 
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");
 
		// set the port of socket factory 
		//props.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		props.put("mail.smtp.starttls.enable", "true");
 
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
 
		// set the port of SMTP server
		props.put("mail.smtp.port", "25");
 
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("Piyushwadhwa23@gmail.com", "Anita@298");
 
					}
 
				});
 
		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("Piyushwadhwa23@gmail.com"));
 
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("Piyushwadhwa23@gmail.com"));
            
                        // Add the subject link
			message.setSubject("Testing Subject");
 
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// Set the body of email
			messageBodyPart1.setText("This is message body");
 
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// Mention the file which you want to send
			String filename = "C:\\Downloads\\InputFile.xlsx";
 
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
 
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// set the file
			messageBodyPart2.setFileName(filename);
 
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
 
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
 
	}

	
	
	
	
	public static void main(String[] args) {
		
		/*
		 * File filename = getLatestFilefromDir("C:\\Downloads"); String Rest =
		 * filename.getName(); System.out.println(Rest);
		 * 
		 * String FIlepath = DriverHelper.downloadPath+"\\"+Rest;
		 * 
		 * System.out.println(FIlepath);
		 */
		
		
		sendmail2();
		
	}

}
