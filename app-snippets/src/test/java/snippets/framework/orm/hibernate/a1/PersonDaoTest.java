package snippets.framework.orm.hibernate.a1;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class PersonDaoTest {
    @Test
    public void testSaveAndList() {
        PersonDao dao = new PersonDao();
        Person p = new Person("peter", new Integer(32));
        dao.save(p);
        
        List<Person> persons = dao.listByCriteria();
        Iterator iterator = persons.iterator();
        
        // this is inserted by SQL before
        Person person = (Person) iterator.next();
        assertEquals(person.getId(), new Integer(1));
        assertEquals(person.getName(), new String("sam"));
        assertEquals(person.getAge(), new Integer(31));
        
        dao.close();
    }
    
    @Test
    public void testListByCriteria() {
        PersonDao dao = new PersonDao();
        Person p = new Person("jeff", new Integer(33));
        dao.save(p);
        
        Criterion criterion = Restrictions.like("name", "%ff");
        List<Person> persons = dao.listByCriteria(criterion);
        Iterator iterator = persons.iterator();
        Person person = (Person) iterator.next();
        
        assertEquals(person.getName(), new String("jeff"));
        assertEquals(person.getAge(), new Integer(33));
        
        dao.delete(p);        
        dao.close();
    }
    
    @Test
    public void testListByHQL() {
        PersonDao dao = new PersonDao();
        Person p = new Person("chris", new Integer(33));
        dao.save(p);
        
        Session session = dao.getSession();
        Query hql = session.createQuery("from Person where name = :name and age = :age");
        hql.setParameter("name", "chris");   
        hql.setParameter("age", new Integer(33));           
        List<Person> persons = dao.listByHQL(hql);
        Iterator iterator = persons.iterator();
        Person person = (Person) iterator.next();
        
        assertEquals(person.getName(), new String("chris"));
        assertEquals(person.getAge(), new Integer(33));
        
        dao.delete(p);    
        dao.close();
    }
    
    @Test
    public void testListByNamedQuery() {
        PersonDao dao = new PersonDao();
        Person p = new Person("cliff", new Integer(35));
        dao.save(p);
        
        Session session = dao.getSession();
        Query hql = session.getNamedQuery("snippets.framework.orm.hibernate.a1.Person.findPersonByName");
        hql.setParameter("name", "cliff");            
        List<Person> persons = dao.listByNamedQuery(hql);
        Iterator iterator = persons.iterator();
        Person person = (Person) iterator.next();
        
        assertEquals(person.getName(), new String("cliff"));
        assertEquals(person.getAge(), new Integer(35));
        
        dao.delete(p);    
        dao.close();
    }
    
    
    @Test
    public void testListByNativeSQL() {
        PersonDao dao = new PersonDao();
        Person p = new Person("mary", new Integer(34));
        dao.save(p);
        
        String sql = "select {p.*} from person p where p.name like '%ry'";
        List<Person> persons = dao.listByNativeSQL(sql);
        Iterator iterator = persons.iterator();
        Person person = (Person) iterator.next();
        
        assertEquals(person.getName(), new String("mary"));
        assertEquals(person.getAge(), new Integer(34));
        
        dao.delete(p);    
        dao.close();
    }
}
