package snippets.jdk.util.collection.iterable.a1;

import java.util.Iterator;
import java.util.StringTokenizer;

public class Tokenizer implements Iterable<String> {
    private StringTokenizer tokenizer;
    
    public Tokenizer(String str) {
        tokenizer = new StringTokenizer(str);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return tokenizer.hasMoreTokens();
            }
            @Override
            public String next() {
                return tokenizer.nextToken();
            }
            @Override
            public void remove() {
                
            }  
        };
    }
}
