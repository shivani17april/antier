/*
package sendEmail;

import Testcases.ContactUsForm;
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


        @Parameters({"sub","message"})
        @Test
        public void sendEmailFxn(String sub, String message) {

            // Recipient's email ID needs to be mentioned.
            System.out.println("TAG send email....");

//        String message = msg;
//        String sub = subMsg;
            String from = "shivani.sharma@antiersolutions.com";
            String to = "chandan.qa@antiersolutions.com";

            //sendEmail(message, sub, to, from);

            // Assuming you are sending email through relay.jangosmtp.net

            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            // Get the Session object.
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //return super.getPasswordAuthentication();  "cryptout431@gmail.com","slinrgxfzpjurbjy"
                    return new passwordauthentication("shivani.sharma@antiersolutions.com", "xmuzjfmjujjpmbte");
                }
            });
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
                messageBodyPart.setText(message);

                // Create a multipar message
                Multipart multipart = new MimeMultipart();

                // Set text message part
                multipart.addBodyPart(messageBodyPart);


// Part two is attachment
                messageBodyPart = new MimeBodyPart();
                BodyPart messageBodyPart1 = new MimeBodyPart();
                BodyPart messageBodyPart2 = new MimeBodyPart();
                //String filename = "C:\\Users\\user\\IdeaProjects\\AntierTest\\test-output\\emailable-report.html";
                String filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\ContactUs.jpg";
                String filename2 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Submit.jpg";
                if (sub.contains("experts")) {



                    System.out.println("TAG : " + "HEREfdsf");
                    filename1 = "C:\\Users\\user\\IdeaProjects\\antier_site\\src\\test\\java\\Utilities\\Talktoexperts.png";
                }

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
//                if (i==2) {
//                    messageBodyPart2.setDataHandler(new DataHandler(source));
//                    messageBodyPart2.setFileName(FileArray[i]);
//                    multipart.addBodyPart(messageBodyPart2, i);
//                }
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


}
*/
