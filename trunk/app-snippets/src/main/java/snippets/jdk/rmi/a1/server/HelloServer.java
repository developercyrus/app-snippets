package snippets.jdk.rmi.a1.server;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer { 
    public static void main(String args[]) throws UnknownHostException { 
        try {   
            /* Important to set the right policy file before starting RMISecurityManager  
             * To make sure this policy file can always be found we included it in the JAR so here we first need to getResource it again */
            URL url = HelloServer.class.getResource("server.policy");
            String serverPolicy = url.toString();
            System.out.println("server.policy=" + serverPolicy);
            
            System.setProperty("java.security.policy", serverPolicy); 
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }

            String server = InetAddress.getLocalHost().getCanonicalHostName();
            int registryPort = 1099;
            int servicePort = 1199;
              
            IHello obj = new HelloImpl();
            /* The static method UnicastRemoteObject.exportObject exports the supplied remote object to receive incoming remote method invocations 
             * on an anonymous TCP port and returns the stub for the remote object to pass to clients.*/            
            /* make that object available to accept incoming calls from clients, otherwise it's a random port, and difficult to config port in firewall*/
            IHello r = (IHello)UnicastRemoteObject.exportObject(obj, servicePort);
            /* this avoids to run "C:\>start rmiregistry 1099" */
            Registry registry = LocateRegistry.createRegistry(registryPort); 
            registry.rebind("RmiHello", r);

            //Naming.bind("rmi://" + server + ":" + port + "/RmiHello", obj);
            System.out.println(">>>>> INFO: " + server + ":" + registryPort + " and obj:" + servicePort + " bind success"); 
            
        } catch (RemoteException e) {             
            e.printStackTrace(); 
        } 
    } 
}