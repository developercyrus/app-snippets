package snippets.jdk.util.regex.a1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FindChineseWordTest {

    @Test
    public void test() {
        String[] words = new String[2];
        FindChineseWord f = new FindChineseWord();
        words[0] = "字";
        words[1] = "串";
        assertArrayEquals(words, f.getWords());
    }

}
