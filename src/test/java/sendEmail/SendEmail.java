package sendEmail;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SendEmail {
//    export SECRET_KEY="hip-hip-env-files"
//    export VERSION="1.0"
    @Parameters({"sub", "message"})
    @Test
    public void sendEmailFxn(String sub, String message) {
       sendMail(sub,message);
        // Recipient's email ID needs to be mentioned.
        System.out.println("TAG send email....");

//        String message = msg;
//        String sub = subMsg;
        String from = "shivani.sharma@antiersolutions.com";
        String to = "mohammad.shaiyad@antiersolutions.com";

        //sendEmail(message, sub, to, from);

        // Assuming you are sending email through relay.jangosmtp.net

        String host = "smtp.sendgrid.ne";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "false");
//        properties.put("mail.smtp.tls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Get the Session object.
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//////                    return super.getPasswordAuthentication("shivani.sharma@antiersolutions.com","xmuzjfmjujjpmbte");
////                return new PasswordAuthentication("shivani.sharma@antiersolutions.com", "xmuzjfmjujjpmbte");
//                return new PasswordAuthentication("apikey",
//                        "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");
//            }
//        });
//        Message m = new MimeMessage(session);  // Create a default MimeMessage object.
//        try {
//            m.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            m.setSubject(sub);
//
//            // Create the message part
//            BodyPart messageBodyPart = new MimeBodyPart();
//
//            // Now set the actual message
//            messageBodyPart.setText(message);
//
//            // Create a multipar message
//            Multipart multipart = new MimeMultipart();
//
//            // Set text message part
//            multipart.addBodyPart(messageBodyPart);
//
//
//// Part two is attachment
//            messageBodyPart = new MimeBodyPart();
//            BodyPart messageBodyPart1 = new MimeBodyPart();
//            BodyPart messageBodyPart2 = new MimeBodyPart();
//            String filename1 = "D:\test.pn";
//            String filename2 = "D:\test1.pn";
//          //  String filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\ContactUs.jpg";
//           // String filename2 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Submit.jpg";
////            if (sub.contains("experts")) {
////
////
////                System.out.println("TAG : " + "HEREfdsf");
////                filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Talktoexperts.png";
////            }
//
//            String[] FileArray = {filename1, filename2};
//            System.out.println("TAG sendEmailFxn: " + FileArray.length);
//            for (int i = 0; i < FileArray.length; i++) {
//                DataSource source = new FileDataSource(FileArray[i]);
//                if (i == 0) {
//                    messageBodyPart.setDataHandler(new DataHandler(source));
//                    messageBodyPart.setFileName(FileArray[i]);
//                    multipart.addBodyPart(messageBodyPart, i);
//                }
//                if (i == 1) {
//                    messageBodyPart1.setDataHandler(new DataHandler(source));
//                    messageBodyPart1.setFileName(FileArray[i]);
//                    multipart.addBodyPart(messageBodyPart1, i);
//                }
//            }
//            // Send the complete message parts
//            m.setContent(multipart);
//
//            // Send message
//            Transport.send(m);
//
//            System.out.println("TAG Sent message successfully....");
//
//        } catch (Exception e) {
//            throw new RuntimeException("TAG : " + e);
//        }
    }

    void sendMail(String sub, String msg) {

        Map<String, String> env = System.getenv();

        System.out.print("TAG user"+env.get("USER"));
        //provide Mailtrap's username
        final String username = env.get("USER");
        final String password = env.get("PASS");
        //provide Mailtrap's password
        //provide Mailtrap's host address
        String host = "smtp.sendgrid.net";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.enable", "true");

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        String to = "shivani.sharma@antiersolutions.com";
        String from = "mohammad.shaiyad@antiersolutions.com";

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
//        try {
//            //create a MimeMessage object
//            Message message = new MimeMessage(session);
//            //set From email field
//            message.setFrom(new InternetAddress(from));
//            //set To email field
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(to));
//            //set email subject field
//            message.setSubject(sub);
//            //set the content of the email message
//            message.setText(msg);
////            message.setContent(multipart);
//            //send the email message
//            Transport.send(message);
//            System.out.println("TAG.. Email Message Sent Successfully");
//        } catch (MessagingException e) {
//            System.out.println("TAG.. "+e.getMessage());
//
//        }
    }

}




