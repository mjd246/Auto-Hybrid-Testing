package utils;

import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import runner.Base;

public class SecureEmailSender extends Base{

	
	private static final String EMAIL_FROM = "manojdeva246@gmail.com";
    private static final String EMAIL_SUBJECT = "Test Results";
    private static final String EMAIL_MESSAGE = "Please find Attached Report....";

    public static void sendEmailWithReport(String reportPath, String recipientEmail) throws MessagingException, IOException {

        // Load email credentials securely (not shown here)
        String username = loadUsername();
        String password = loadPassword();

 
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587"); // Use port 587 for STARTTLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        message.setSubject(EMAIL_SUBJECT);

        // Create a multipart message for text and attachment
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent(EMAIL_MESSAGE, "text/plain");
        multipart.addBodyPart(textPart);

        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.attachFile(reportPath);
        attachmentPart.setDisposition(MimeBodyPart.ATTACHMENT);
        attachmentPart.setFileName("extent_report.html");
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Email sent successfully!");
    }

    // Helper methods for credential loading and report path validation (implement these)
    private static String loadUsername() {
    	System.out.println(prop.getProperty("username") );
    return prop.getProperty("username"); 
    
    	
    }

    private static String loadPassword() {
    	System.out.println(prop.getProperty("pwd") );
    	return prop.getProperty("pwd"); 
    	
    }


}

