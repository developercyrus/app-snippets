package snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1.PersonDao;
import snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1.generated.Person;

public class PersonDaoTest {
    @Test
    public void test() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.listByCriteria();
        Iterator iterator = persons.iterator();
       
        Person person = (Person) iterator.next();
        assertEquals(person.getId(), new Integer(1));
        assertEquals(person.getName(), new String("john"));
        assertEquals(person.getAge(), new Integer(42));
       
        dao.close();
    }
}
