package snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;

import snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1.generated.Person;

public class PersonDao {
    private Session session;
    private SessionFactory sessionFactory;
    
    public PersonDao() {
        Configuration config = new Configuration().configure("/snippets/framework/orm/hibernate/hibernate3/maven/plugin/a1/hibernate.cfg.xml");  
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public List<Person> listByCriteria() {
        Criteria criteria = session.createCriteria(Person.class);
        List<Person> users = criteria.list();

        return users;
    }  
        
    public Session getSession() {
        return session;
    }
    
    public void close() {
        session.close();
        sessionFactory.close();  
    }
}