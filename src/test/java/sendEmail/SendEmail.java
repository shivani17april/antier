package sendEmail;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;

public class SendEmail {



    @Parameters({"sub", "message"})
    @Test
    public void sendEmailFxn(String sub, String message) {
//        sub="subject here";
//        message="message here";
        sendMail(sub, message);

    }

    void sendMail(String sub, String msg) {

        final String username = "web-reports@antiers.work";
        final String password = "DBC1AEEBAD63381A2F35C1059C0D0FCCECD5";
        //provide Mailtrap's host address
        String host = "smtp.elasticemail.com";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.enable", "true");
//25, 2525, 587, 465
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
//        props.put("mail.debug", "true");
        String to = "shivani.sharma@antiersolutions.com";
        String from = "web-reports@antiers.work";

        //create the Session object
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(props, authenticator);
        Message m = new MimeMessage(session);  // Create a default MimeMessage object.
        try {
            m.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            m.setSubject(sub);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(msg);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);


// Part two is attachment
            messageBodyPart = new MimeBodyPart();
            BodyPart messageBodyPart1 = new MimeBodyPart();
            BodyPart messageBodyPart2 = new MimeBodyPart();
            String filename1 = "D:\\test.png";
            String filename2 = "D:\\test1.png";
            //  String filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\ContactUs.jpg";
            // String filename2 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Submit.jpg";
//            if (sub.contains("experts")) {
//
//
//                System.out.println("TAG : " + "HEREfdsf");
//                filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Talktoexperts.png";
//            }

            String[] FileArray = {filename1, filename2};
            System.out.println("TAG sendEmailFxn: " + FileArray.length);
            for (int i = 0; i < FileArray.length; i++) {
                DataSource source = new FileDataSource(FileArray[i]);
                if (i == 0) {
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(FileArray[i]);
                    multipart.addBodyPart(messageBodyPart, i);
                }
                if (i == 1) {
                    messageBodyPart1.setDataHandler(new DataHandler(source));
                    messageBodyPart1.setFileName(FileArray[i]);
                    multipart.addBodyPart(messageBodyPart1, i);
                }
            }
            // Send the complete message parts
            m.setContent(multipart);

            // Send message
            Transport.send(m);

            System.out.println("TAG Sent message successfully....");

        } catch (Exception e) {
            throw new RuntimeException("TAG : " + e);
        }

    }

}




