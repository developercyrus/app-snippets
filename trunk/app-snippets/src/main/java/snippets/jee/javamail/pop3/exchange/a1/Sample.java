package snippets.jee.javamail.pop3.exchange.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class Sample {
    public static void main(String[] args) throws Exception {
        String host = "exchange2.home.org";
        
        Authenticator authenticator = new Authenticator(); 
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host); 
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true"); 
        //props.put("mail.smtp.auth.mechanisms","NTLM"); 
        props.put("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName()); 
        System.out.println(authenticator.getPasswordAuthentication().getUserName());
        Session session = Session.getInstance(props, authenticator); 
        session.setDebug(true); 

        Store store = session.getStore("pop3");
        //store.connect();

        Folder folder = store.getDefaultFolder();
        if (folder == null) throw new Exception("No default folder");
        folder = folder.getFolder("INBOX");
        if (folder == null) throw new Exception("No POP3 INBOX");
        folder.open(Folder.READ_ONLY);
        Message[] msgs = folder.getMessages();
        for (int msgNum = 0; msgNum < msgs.length; msgNum++) {
            printMessage(msgs[msgNum]);
        }

    }

    public static void printMessage(Message message) throws IOException, MessagingException {
        Part messagePart = message;

        Object content = messagePart.getContent();
        if (content instanceof Multipart) {
            messagePart = ((Multipart) content).getBodyPart(0);
            System.out.println("[ Multipart Message ]");
        }
        String contentType = messagePart.getContentType();
        System.out.println("CONTENT:" + contentType);
        if (contentType.startsWith("text/plain") || contentType.startsWith("text/html")) {
            InputStream is = messagePart.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String thisLine = reader.readLine();
            System.out.println(thisLine);
        }
    }
}
