package snippets.apache.commons.beanutils.a1;

import java.util.Date;
import java.util.Map;

import static org.hamcrest.collection.IsMapContaining.hasEntry; //come from hamcrest-integration-1.2.1.jar
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.hamcrest.Matcher;
import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Date now = new Date();
        Person p = new Person("John", 32, now);
        String s = "{name=John, age=32, class=" + p.getClass().toString() + ", date=" + now.toString() + "}";
        assertEquals(s, p.toString());
    }
    
    @Test
    public void testEntryByHamcrest() {
        Date now = new Date();
        Person p = new Person("John", 32, now);
        Map<?, ?> m = p.toMap();
        assertThat(m, (Matcher)hasEntry("name","John"));
        assertThat(m, (Matcher)hasEntry("age","32"));
        assertThat(m, (Matcher)hasEntry("date",now.toString()));
    }
}
