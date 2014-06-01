package snippets.jee.jndi.rmiregistry.a1.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class RegisteringJNDIWithDataSourceServer {

    public static void main(String args[]) throws RemoteException, NamingException, SQLException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        properties.put(Context.PROVIDER_URL, "rmi://localhost:1059");
        InitialContext context = new InitialContext(properties);
        
        ConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("");
        ((MysqlDataSource) dataSource).setServerName("localhost");
        ((MysqlDataSource) dataSource).setPort(3306);
        ((MysqlDataSource) dataSource).setDatabaseName("cyrus");

        LocateRegistry.createRegistry(1059);
        System.out.println("RMI registry Stared.");
        
        context.rebind("jdbc/Mysql", dataSource);           
    }
}