package snippets.jdk.jdbc.a1;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() throws SQLException {
        MySQLConnection db = new MySQLConnection();
        Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from snippets_jdk_jdbc_a1.person");
        while (rs.next()) {
            assertEquals(1, rs.getInt("id"));
            assertEquals("sam", rs.getString("firstname"));
        }
    }
}
