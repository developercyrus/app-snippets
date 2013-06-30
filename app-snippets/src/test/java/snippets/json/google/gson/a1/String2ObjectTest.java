package snippets.json.google.gson.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class String2ObjectTest {

    @Test
    public void test() throws IOException {
        String path = this.getClass().getResource("data.json").getFile();
        
        String line, jsonStr = "";
        BufferedReader br = new BufferedReader(new FileReader(path));       
        while ((line = br.readLine()) != null) {
            jsonStr = jsonStr + line;
        }
        
        Data data = String2Object.convert(jsonStr);
        assertEquals("ComputingandInformationsystems", data.getTitle());
        assertEquals("LeveloneCIS", data.getGroups().get(0).getTitle());
        assertEquals("IntroToComputingandInternet", data.getGroups().get(0).getGroups().get(0).getTitle());
    }
}
