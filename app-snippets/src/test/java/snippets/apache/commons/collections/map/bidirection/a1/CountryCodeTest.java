package snippets.apache.commons.collections.map.bidirection.a1;

import static org.hamcrest.collection.IsMapContaining.hasEntry; //come from hamcrest-integration-1.2.1.jar
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Test;

public class CountryCodeTest {
    @Test
    public void test() {
        CountryCode countryCodes = new CountryCode();
        assertEquals("Turkey", (String)countryCodes.get("tr"));
        assertEquals("tr", (String)countryCodes.getKey("Turkey"));
        assertEquals("tr", (String)countryCodes.inverseBidiMap().get("Turkey"));
    }
    
    @Test
    public void testEntryByHamcrest() {
        CountryCode countryCodes = new CountryCode();
        assertThat(countryCodes, (Matcher)hasEntry("to","Tonga"));
    }
    
    @Test
    public void testDuplicateKey() {
        CountryCode countryCodes = new CountryCode();
        countryCodes.put("to", "TOO");
        assertEquals("TOO", (String)countryCodes.get("to"));
    }

    @Test
    public void testDuplicateValue() {
        CountryCode countryCodes = new CountryCode();
        countryCodes.put("too", "TOO");
        assertEquals("too", (String)countryCodes.getKey("TOO"));
    }
}
