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

public class Sample2 {
    public static void main(String[] args) throws Exception {
        String host = "exchange2.home.org";
        
        Properties props = System.getProperties();
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("pop3");
        store.connect(host, "", "");


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
