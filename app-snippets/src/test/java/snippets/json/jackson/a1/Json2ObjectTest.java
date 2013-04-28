package snippets.json.jackson.a1;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class Json2ObjectTest {
    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException {
        String jsonPath = this.getClass().getResource("equation.json").getFile();
        
        String line, jsonStr = "";
        BufferedReader br = new BufferedReader(new FileReader(jsonPath));       
        while ((line = br.readLine()) != null) {
            jsonStr = jsonStr + line;
        }
        
        List<String> result = new ArrayList<String>();
      
        ObjectMapper mapper = new ObjectMapper(); 
        Equation equation = mapper.readValue(jsonStr, Equation.class);
        List<Element> elements = equation.getElements();
        for (Element e : elements) {
            result.add(e.getValue());
        }

        String[] actual = new String[result.size()];
        actual = result.toArray(actual);
        String[] expected = {"1", "2"};
        
        assertArrayEquals(expected, actual);        
    }
}
