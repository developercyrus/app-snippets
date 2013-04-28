/*
 * http://www.objectpartners.com/2009/12/04/write-readable-tests-with-mockito/
 */

package snippets.framework.mock.mockito.a2;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class PersonServiceTest {
    private PersonService personService;
    private PersonDao personDao;

    @Before
    public void before() {
        this.personDao = mock(PersonDao.class);
        this.personService = new PersonService(personDao);
    }

    @Test
    public void testUpdate () {
        Person person = new Person(1, "john");
        /*
         *  The personDao.fetchPerson() method is stubbed simply by 
         *  calling when(personDao.fetchPerson(1)).thenReturn(person). 
         *  This statement informs the mock PersonDao to return person when 
         *  the fetchPerson method is called with a value of 1.
         */
        when(personDao.fetchPerson(1)).thenReturn(person);

        boolean updated = personService.update(1, "joe");
        assertTrue(updated);

        /*
         *  The statement verify(personDao).fetchPerson(1) verifies that 
         *  personDao.fetchPerson is called with a value of 1. 
         *  If it is not, the test will fail.
         */
        verify(personDao).fetchPerson(1);

        /*
         *  The ArgumentCaptor provides a really slick way to capture the variable passed to 
         *  the update method of the PersonDao. And, easily allows me to assert that 
         *  the name has changed to the new value.
         */
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personDao).update(personCaptor.capture());
        Person updatedPerson = personCaptor.getValue();
        assertEquals("joe", updatedPerson.getName());

        /* 
         *  The verifyNoMoreInteractions(personDao) statement asserts that 
         *  during the test, there are no other calls to the mock object.
         */
        verifyNoMoreInteractions(personDao);
    }
    
    @Test
    public void testUpdateIfPersonNotFound() {
        when(personDao.fetchPerson(1)).thenReturn(null);

        boolean updated = personService.update(1, "joe");
        assertFalse(updated);

        verify(personDao).fetchPerson(1);
        verifyNoMoreInteractions(personDao);
    }

}
