package snippets.jdk.util.collection.map.hashmap.weakhashmap.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapMain2 {
    private static Map<String, String> map;
    public static void main (String args[]) throws InterruptedException {                
        // being in use
        String s1 = new String ("Sam");
        List<String> l = new ArrayList<String>();
        l.add(s1);
        
        // finalized
        final String s2 = new String ("John");        
        
        map = new WeakHashMap<String, String>();
        map.put(new String("Scott"), "1");
        map.put(new String("Mary"), "2");
        map.put(new String("Peter"), "3");
        map.put(s1, "11");
        map.put(s2, "12");
        
        System.out.println(map);
        for (int i=0; i<50; i++) {
            Thread.sleep(100); 
            System.out.println("sleeping");
            System.gc();
        }
        System.out.println(map);
    }
}
