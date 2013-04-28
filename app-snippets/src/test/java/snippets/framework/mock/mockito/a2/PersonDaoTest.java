package snippets.framework.mock.mockito.a2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonDaoTest {
    
    @Test
    public void testFetchPerson() {
        PersonDao personDao = new PersonDaoImpl();
        Person person = personDao.fetchPerson(new Integer(1));
        
        assertEquals("sam", person.getName());
    }
}
