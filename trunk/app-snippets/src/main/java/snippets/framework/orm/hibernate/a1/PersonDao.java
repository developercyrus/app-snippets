package snippets.framework.orm.hibernate.a1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

public class PersonDao {
    private Session session;
    private SessionFactory sessionFactory;
    
    public PersonDao() {
        Configuration config = new Configuration().configure("/snippets/framework/orm/hibernate/a1/hibernate.cfg.xml");
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().configure().buildServiceRegistry();       
        //sessionFactory = config.buildSessionFactory(serviceRegistry);        
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public void save(Person person) {
        Transaction tx = session.beginTransaction();
        session.save(person);          
        tx.commit();
    }
    
    public void delete(Person person) {
        Transaction tx = session.beginTransaction();
        session.delete(person);  
        tx.commit();
    }
    
    public List<Person> listByCriteria() {
        Criteria criteria = session.createCriteria(Person.class);
        List<Person> users = criteria.list();

        return users;
    }  
    
    public List<Person> listByCriteria(Criterion criterion) {
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(criterion);
        List<Person> users = criteria.list();

        return users;
    }  
    
    public List<Person> listByHQL(Query hql) {     
        List<Person> users = hql.list();

        return users;
    }  
    
    public List<Person> listByNamedQuery(Query hql) {     
        List<Person> users = hql.list();

        return users;
    }
    
    public List<Person> listByNativeSQL(String sql) {
        List<Person> users = session.createSQLQuery(sql).addEntity("p", Person.class).list();

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