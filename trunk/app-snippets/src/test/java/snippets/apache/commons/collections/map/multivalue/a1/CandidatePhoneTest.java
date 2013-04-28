package snippets.apache.commons.collections.map.multivalue.a1;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandidatePhoneTest {
    @Test
    public void test() {
        CandidatePhone candidatePhones = new CandidatePhone();
        Collection<?> values = (Collection<?>) candidatePhones.get("John");
        Iterator<?> valuesIterator = values.iterator( );
        assertEquals("98661234", valuesIterator.next());
        assertEquals("96541789", valuesIterator.next());
    }
}
