package snippets.jee.jpa.openjpa.a1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CustomerTest {
    
    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snippets.jee.jpa.openjpa.a1.Customer");
        EntityManager em = emf.createEntityManager();

        String q = "SELECT c FROM Customer AS c";
        Query query = (Query) em.createQuery(q);
        List l =  query.getResultList();
        assertEquals(1, ((Customer)l.get(0)).getId());
        assertEquals("mary", ((Customer)l.get(0)).getName());
    }
}