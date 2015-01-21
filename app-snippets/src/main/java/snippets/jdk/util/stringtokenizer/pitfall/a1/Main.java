package snippets.jdk.util.stringtokenizer.pitfall.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {        
    public static String[] splitByTokenizer(String s) {       
        StringTokenizer st = new StringTokenizer(s, "###");
        List<String> l = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            l.add(st.nextToken());
        }
        
        String[] result = new String[l.size()];
        return l.toArray(result);
    }
    
    public static String[] splitByRegex(String s) {
        List<String> l = new ArrayList<String>();
        for (String token : s.split("###")) {
            l.add(token);
        }
        
        String[] result = new String[l.size()];
        return l.toArray(result);
    }
    
    
}



