package snippets.jdk.util.collection.iterable.a1;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TokenizerTest {
    @Test
    public void test() {
        Tokenizer tokenizer = new Tokenizer("I am Peter Chan");
        String[] expected = {"I", "am", "Peter", "Chan"};
        List<String> list = new ArrayList<String>();
        
        for (String token: tokenizer) {
            list.add(token);
        }
        String[] actual = new String[list.size()];
        actual = list.toArray(actual);
        
        assertArrayEquals(expected, actual);
    }
}
