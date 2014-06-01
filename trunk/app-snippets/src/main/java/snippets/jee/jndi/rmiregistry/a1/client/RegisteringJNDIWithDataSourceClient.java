package snippets.jee.jndi.rmiregistry.a1.client;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class RegisteringJNDIWithDataSourceClient {

    public static void main(String args[]) throws RemoteException, NamingException, SQLException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        properties.put(Context.PROVIDER_URL, "rmi://localhost:1059");
        InitialContext context = new InitialContext(properties);
        
        ConnectionPoolDataSource ds = (MysqlConnectionPoolDataSource) context.lookup("jdbc/Mysql");
        PooledConnection pConn = ds.getPooledConnection();
        Connection conn = pConn.getConnection();        
        Statement stmt = conn.createStatement();        
        ResultSet rs = stmt.executeQuery("select firstname from student where id = 2");
        while (rs.next()) {
            System.out.println(rs.getString("firstname"));
        }              
    }
}