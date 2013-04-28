package snippets.framework.mock.mockito.a2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonDaoImpl implements PersonDao {
    private Session session;
    private SessionFactory sessionFactory;
    
    public PersonDaoImpl() {
        Configuration config = new Configuration().configure("/snippets/framework/mock/mockito/a2/hibernate.cfg.xml");        
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public Person fetchPerson(Integer id) {
        Query hql = session.createQuery("from Person where id = :id");  
        hql.setParameter("id", id);           
        List<Person> persons = hql.list();
        Iterator iterator = persons.iterator();
        return (Person) iterator.next();        
    }
    
    public void update(Person person) {
        Query hql = session.createQuery("update Person set name = :name where id = :id"); 
        hql.setParameter("id", person.getId());
        hql.setParameter("name", person.getName());
        int result = hql.executeUpdate();
    }
}
