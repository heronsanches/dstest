package lunch.hour.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

   private static final String SMTP_USERNAME = "";
   private static final String SMTP_PASSWORD = "";
   private static final String HOST = "smtp.gmail.com";
   private static final int PORT = 465;

   /**
    * Email OK. It means that the EMAIL_* was verified and the mx record is
    * valid.
    */
   public static int EMAIL_OK = 20;

   /**
    * Domain contains illegal character OR Domain starts with dot OR Invalid
    * Addresses OR Domain mx not valid.
    */
   public static int EMAIL_INCORRECT = 21;

   /**
    * Couldn't connect to host...
    */
   public static int EMAIL_CHECK_INTERNET_CONNECTION = 22;

   /**
    * IOException | InterruptedException when try to use nslookup domain from linux
    */
   public static int EMAIL_TRY_AGAIN = 23;

   /**
    * IOException | InterruptedException when try to use nslookup domain from linux
    */
   public static int EMAIL_WITHOUT_RECIPIENTS = 24;

   public static int EMAIL_ERROR_UNKNOWN = 25;

   
   private EmailUtils() {
   }
   

   public static int enviarEmail(String fromEmail, String messageContent, String subject, String recipient) {

      Properties props = System.getProperties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.port", PORT);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.ssl.enable", "true");

      Session session = Session.getInstance(props);
      MimeMessage msg = new MimeMessage(session);
      Transport transport = null;

      try {

         msg.setFrom(new InternetAddress(fromEmail));
         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

         if (checkMx(recipient) != EmailUtils.EMAIL_OK) {
            return EmailUtils.EMAIL_INCORRECT;
         } else {
            Logger.getLogger(EmailUtils.class.getName()).log(Level.INFO, "incorrect domain");
         }

         msg.setSubject(subject);
         msg.setContent(messageContent, "text/html;charset=UTF-8");

         transport = session.getTransport();
         transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

         transport.sendMessage(msg, msg.getAllRecipients());
         return EmailUtils.EMAIL_OK;

      } catch (SendFailedException se) {

         Logger.getLogger(EmailUtils.class.getName()).log(Level.INFO, null, se);
         return EmailUtils.EMAIL_INCORRECT;

      } catch (MessagingException me) {

         String error = me.getMessage();
         Logger.getLogger(EmailUtils.class.getName()).log(Level.INFO, null, me);

         if (error.contains("Domain contains illegal character") || error.contains("Domain starts with dot")) {
            return EmailUtils.EMAIL_INCORRECT;
         }

         if (error.contains("Couldn't connect to host")) {
            return EmailUtils.EMAIL_CHECK_INTERNET_CONNECTION;
         }

      } finally {

         try {
            transport.close();
         } catch (MessagingException e) {
            Logger.getLogger(EmailUtils.class.getName()).log(Level.INFO, null, e);
         }

      }

      return EmailUtils.EMAIL_ERROR_UNKNOWN;

   }

   
   private static int checkMx(String toEmail) {

      //OBS: It checks the domain mx record. At testing state!*/
      String domainName = toEmail.split("@")[1];
      String command = "nslookup -type=mx " + domainName;
      Process proc;
      boolean mxOk = false;

      try {

         proc = Runtime.getRuntime().exec(command);
         BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
         String line = "";

         while ((line = reader.readLine()) != null) {

            if (line.contentEquals("Non-authoritative answer:")) {

               line = reader.readLine();

               if (line.contains(domainName)) {
                  mxOk = true;
               }

            }

         }

         proc.waitFor();
         reader.close();

         if (!mxOk) {
            return EmailUtils.EMAIL_INCORRECT;
         }

      } catch (IOException | InterruptedException ex) {

         Logger.getLogger(EmailUtils.class.getName()).log(Level.SEVERE, null, ex);
         return EmailUtils.EMAIL_TRY_AGAIN;

      }

      return EmailUtils.EMAIL_OK;

   }
   

}