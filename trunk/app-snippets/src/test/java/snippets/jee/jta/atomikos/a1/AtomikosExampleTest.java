package snippets.jee.jta.atomikos.a1;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class AtomikosExampleTest {
    @Test
    public void test() throws SQLException {
        String[] args = {};
        AtomikosExample.main(args);
        
        Connection conn1 = this.getDS1();
        Connection conn2 = this.getDS2();
        
        Statement stmt1 = conn1.createStatement();
        ResultSet rs1 = stmt1.executeQuery("select count(*) as cnt from useraccount");
        while (rs1.next()) {
            assertEquals(0, rs1.getInt("cnt"));
        }
        
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery("select count(*) as cnt from useraccount");
        while (rs2.next()) {
            assertEquals(0, rs2.getInt("cnt"));
        }
    }
    
    public Connection getDS1() {
        Connection conn = null;
        
        String protocol = "mysql";
        String servername = "localhost";
        String port = "3306";
        String databasename = "snippets_jee_jta_atomikos_a1";
        String username = "root";
        String password = "";            
        String CONNECTION = "jdbc:" + protocol + "://" + servername + ":" + port + "/" + databasename;         
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(DRIVER_NAME);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            System.out.println(CONNECTION);
            conn = DriverManager.getConnection(CONNECTION, username, password);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    
    public Connection getDS2() {
        Connection conn = null;
        
        String protocol = "postgresql";
        String servername = "localhost";
        String port = "5432";
        String databasename = "snippets_jee_jta_atomikos_a1";
        String username = "postgres";
        String password = "";            
        String CONNECTION = "jdbc:" + protocol + "://" + servername + ":" + port + "/" + databasename;         
        String DRIVER_NAME = "org.postgresql.Driver";
        
        try {
            Class.forName(DRIVER_NAME);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            System.out.println(CONNECTION);
            conn = DriverManager.getConnection(CONNECTION, username, password);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
}
