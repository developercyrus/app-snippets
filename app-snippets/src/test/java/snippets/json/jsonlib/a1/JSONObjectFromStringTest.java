package snippets.json.jsonlib.a1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.junit.Test;

public class JSONObjectFromStringTest {
    @Test
    public void test() {
        String str = "{'string':'JSON', 'integer': 1, 'double': 2.0, 'boolean': true}";  
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON( str );  
        assertEquals("JSON", jsonObject.getString("string"));        
        assertEquals(1, jsonObject.getInt("integer"));        
        assertEquals(2.0d, jsonObject.getDouble("double"), 0d);        
        assertTrue(jsonObject.getBoolean("boolean") );     
    }
}
