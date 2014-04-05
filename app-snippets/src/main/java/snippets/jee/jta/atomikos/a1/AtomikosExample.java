package snippets.jee.jta.atomikos.a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

/*
//conceptual skeleton
try{ 
    userTx = (UserTransaction)getContext().lookup("java:comp/UserTransaction"); 
    connA = getDataSourceA().getConnection(); 
    connB = getDataSourceB().getConnection(); 
    
    userTx.begin();
     
    stmtA = connA.createStatement(); 
    stmtA.execute("update t_account set amount = amount - 500 where account_id = 'A'");
     
    stmtB = connB.createStatement(); 
    stmtB.execute("update t_account set amount = amount + 500 where account_id = 'B'");
    
    userTx.commit();

} catch(SQLException sqle) { 
    try{ 
        userTx.rollback();
        stmtA.close();
        stmtB.close();  
        connA.close();
        connB.close();                 
    } catch(Exception ignore){ 
     
    } 
      
    sqle.printStackTrace(); 
 
} catch(Exception e) { 
    e.printStackTrace(); 
} 
*/

public class AtomikosExample {
    public static void main(String[] args)  {        
        Connection conn1 = null;
        Connection conn2 = null;
        UserTransaction userTx = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String created_date = sdf.format(new Date()); 
        String sql1 = "insert into useraccount (id, firstname, created_date) values (?, ?, ?)";
        String sql2 = "insert into useraccount (id, firstname1, created_date) values (?, ?, ?)"; //intended to cause error, and rollback.
        
        
        try {        
            userTx = new UserTransactionImp();
            //being XA transaction 
            userTx.begin(); 
            
            
            conn1 = getDataSource1().getConnection();
            conn2 = getDataSource2().getConnection();
            
            stmt1 = conn1.prepareStatement(sql1);
            stmt1.setInt(1, 1);
            stmt1.setString(2, "ds1");
            stmt1.setString(3, created_date);
            
            stmt2 = conn2.prepareStatement(sql2);
            stmt2.setInt(1, 1);
            stmt2.setString(2, "ds2");
            stmt2.setString(3, created_date);
            
            
            stmt1.execute();
            stmt2.execute();
            
            userTx.commit(); 
            //end XA transaction            
        } catch (SQLException e) {
            
            try {
                userTx.rollback();               
                System.out.println("rollback success");
            } catch (IllegalStateException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            
            e.printStackTrace();        
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt1.close();
                stmt2.close();
                
                conn1.close(); 
                conn2.close();
                
                System.out.println("connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }                     
        }
    }
        
    public static AtomikosDataSourceBean getDataSource1() {
        /*
         * connect to zwamp-1.1.2
         */
        AtomikosDataSourceBean ds1 = new AtomikosDataSourceBean();        
        ds1.setUniqueResourceName("jdbc/mysql");
        // driver class file included in mysql-connector-java-5.1.9.jar
        ds1.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        Properties p1 = new Properties();
        p1.setProperty("serverName", "localhost");
        p1.setProperty("port", "3306");
        p1.setProperty("databaseName", "snippets_jee_jta_atomikos_a1");        
        p1.setProperty("user", "root");
        p1.setProperty("password", "");                
        p1.setProperty("url", "jdbc:mysql://localhost:3306/snippets_jee_jta_atomikos_a1?user=root&password=");
        ds1.setXaProperties(p1); 
        
        return ds1;
    }
    
    public static AtomikosDataSourceBean getDataSource2() { 
        /*
         * connect to postgresql 9.2.4
         */
        AtomikosDataSourceBean ds2 = new AtomikosDataSourceBean();
        ds2.setUniqueResourceName("jdbc/postgresql");
        ds2.setXaDataSourceClassName("org.postgresql.xa.PGXADataSource");
        Properties p2 = new Properties();
        p2.setProperty("serverName", "localhost");
        //p2.setProperty("port", "5432");
        p2.setProperty("databaseName", "snippets_jee_jta_atomikos_a1");        
        p2.setProperty("user", "postgres");
        p2.setProperty("password", "");                 
        //p2.setProperty("url", "jdbc:postgresql://localhost:5432/snippets_jee_jta_atomikos_a1?user=root&password=");
        ds2.setXaProperties(p2); 
        
        return ds2;
    }
}

