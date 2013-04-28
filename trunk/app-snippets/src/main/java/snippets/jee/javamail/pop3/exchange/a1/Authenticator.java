package snippets.jee.javamail.pop3.exchange.a1;

import javax.mail.PasswordAuthentication;

public class Authenticator extends javax.mail.Authenticator { 
    private PasswordAuthentication authentication; 

    public Authenticator() { 
        String username = ""; 
        String password = ""; 
        authentication = new PasswordAuthentication(username, password); 
    } 

    public  PasswordAuthentication getPasswordAuthentication() { 
        return authentication; 
    } 
} 