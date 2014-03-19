package snippets.jdk.rmi.a1.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {
    public String sayHello(String client, String msg) throws RemoteException;    
}
