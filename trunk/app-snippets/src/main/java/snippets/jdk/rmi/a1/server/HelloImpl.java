package snippets.jdk.rmi.a1.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class HelloImpl implements IHello { 
    private String server = null;

    public HelloImpl() throws RemoteException { 
        try {
            server = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    } 

    @Override
    public String sayHello(String client, String msg) throws RemoteException {        
        return msg + " from " + client + " to " + server; 
    } 
}