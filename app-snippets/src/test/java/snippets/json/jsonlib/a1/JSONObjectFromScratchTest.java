package snippets.json.jsonlib.a1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.sf.json.JSONObject;

import org.junit.Test;

public class JSONObjectFromScratchTest {
    
    @Test
    public void test() {
        JSONObject jsonObject = new JSONObject().element("string", "JSON")
                                                .element("integer", "1")
                                                .element("double", "2.0")
                                                .element("boolean", "true");
        assertEquals("JSON", jsonObject.getString("string"));
        assertEquals(1, jsonObject.getInt("integer"));
        assertEquals(2.0d, jsonObject.getDouble("double"), 0d);
        assertTrue(jsonObject.getBoolean("boolean"));
    }
}
