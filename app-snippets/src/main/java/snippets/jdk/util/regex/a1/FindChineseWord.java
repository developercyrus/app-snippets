package snippets.jdk.util.regex.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindChineseWord {
    List<String> l = new ArrayList<String>();
    
    public FindChineseWord() {
        Matcher matcher = Pattern.compile("\\p{InCJKUnifiedIdeographs}").matcher("12Domm字串345");
        while ( matcher.find() ) {
            String w = matcher.group();
            l.add(w);
        }
    }
    
    public String[] getWords() {
        String[] str = l.toArray(new String[l.size()]);  
        return str;
    }
}