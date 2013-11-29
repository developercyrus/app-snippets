package snippets.jdk.jdbc.preparedstatement.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLCreator {
    public String getSQL(Connection conn) throws SQLException {
        String username = "peter";
        int roomNumber = 1415;       
        PreparedStatement stmt = null;
        
        stmt = conn.prepareStatement("DROP TABLE IF EXISTS USERS");
        stmt.execute();
        
        stmt = conn.prepareStatement("CREATE TABLE USERS (USERNAME VARCHAR(100), ROOM INT)");
        stmt.execute();
        
        stmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND ROOM = ?");
        stmt.setString(1, username);
        stmt.setInt(2, roomNumber);
        
        return stmt.toString();
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:myDB", "sa", "");
        
        
        /*
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true");
        
        */
        

        /*
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:memory");
        */
        SQLCreator s = new SQLCreator();
        System.out.println(s.getSQL(conn));
    }
}
