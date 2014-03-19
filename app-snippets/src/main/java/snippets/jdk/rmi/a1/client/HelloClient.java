package snippets.jdk.rmi.a1.client;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import snippets.jdk.rmi.a1.server.IHello;

public class HelloClient { 
    public static void main(String args[]) throws UnknownHostException{ 
        try { 
            /* Important to set the right policy file before starting RMISecurityManager  
             * To make sure this policy file can always be found we included it in the JAR so here we first need to getResource it again */
            URL url = HelloClient.class.getResource("client.policy");
            String clientPolicy = url.toString();
            System.out.println("client.policy=" + clientPolicy);
            
            System.setProperty("java.security.policy", clientPolicy); 
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            
            String client = InetAddress.getLocalHost().getCanonicalHostName();
            String server = args[0];
            String port = args[1];
            
            System.out.println("trying to connect to " + server + ":" + port); 
            IHello obj = (IHello)Naming.lookup("rmi://" + server + ":" + port + "/RmiHello"); 
            System.out.println(obj.sayHello(client, "Hello World"));
            
        } catch (NotBoundException e) {             
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
    } 
}