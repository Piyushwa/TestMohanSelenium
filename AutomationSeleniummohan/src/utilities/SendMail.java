package utilities;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void sendmaiwithattachment() throws AddressException  {

		// email ID of Recipient.
String recipient = "Piyush.wadhwa@cisive.com,Mohan.Mishra@cisive.com";
InternetAddress[] iAdressArray = InternetAddress.parse(recipient);
		// email ID of Sender.
		String sender = "Piyush.wadhwa@cisive.com";
		
// using host as localhost
String host = "10.2.11.148";

		// Getting system properties
Properties properties = System.getProperties();

		// Setting up mail server
properties.setProperty("mail.smtp.host", host);

		// creating session object to get properties
Session session = Session.getDefaultInstance(properties);

try {
			// MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From Field: adding senders email to from field.
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.CC, iAdressArray);
			//message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient"));
			
			// message.addRecipient(Message.RecipientType.TO, new
			// InternetAddress(reciptants));
			BodyPart messageBodyPart1 = new MimeBodyPart();
			// Set Subject: subject of the email
			message.setSubject("Automation Testing Report");

			// set body of the email.
			messageBodyPart1.setText("Hi,\n\nPlease find attached automation scripts execution reports.\n\n Regards,\nAutomationQA");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = "C:\\Users\\piyushwadhwa\\workspace\\Levels\\TestReport\\Levels-Automaton-Report.html";

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
			message.setContent(multipart, "text/html");

			// Send email.
			Transport.send(message);
			System.out.println("Mail successfully sent");
		}

catch (MessagingException mex) {
			mex.printStackTrace();
		}


	}
	
	
}