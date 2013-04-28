package snippets.jee.jpa.hibernate.a1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import snippets.jee.jpa.hibernate.a1.Person;

public class PersonTest {
    
    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snippets.jee.jpa.hibernate.a1.Person");
        EntityManager em = emf.createEntityManager();

        String q = "SELECT p FROM Person AS p";
        Query query = (Query) em.createQuery(q);
        List l =  query.getResultList();
        assertEquals(new Long(1), ((Person)l.get(0)).getId());
        assertEquals("mary", ((Person)l.get(0)).getFirstname());
    }
}