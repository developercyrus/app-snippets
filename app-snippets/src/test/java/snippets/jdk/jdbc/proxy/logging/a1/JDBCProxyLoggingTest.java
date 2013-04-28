package snippets.jdk.jdbc.proxy.logging.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class JDBCProxyLoggingTest {
    @Test
    public void testJdbcLogging() throws Exception {
        Class.forName("org.jdbcdslog.DriverLoggingProxy");
 
        String targetDriver = "com.mysql.jdbc.Driver";
        String targetUrl = "mysql://localhost:3306/snippets_jdk_jdbc_proxy_logging_a1";
        String url = "jdbc:jdbcdslog:" + targetUrl + ";targetDriver=" + targetDriver;
 
        Connection conn = DriverManager.getConnection(url, "root", "");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE CHEESE(NAME VARCHAR(200), STRENGTH INT)");
        stmt.execute("INSERT INTO CHEESE(NAME, STRENGTH) VALUES('Edam', 2)");
        stmt.execute("INSERT INTO CHEESE(NAME, STRENGTH) VALUES('Cheddar', 5)");
        stmt.execute("INSERT INTO CHEESE(NAME, STRENGTH) VALUES('Vieux Boulogne', 10)");
    }
}
