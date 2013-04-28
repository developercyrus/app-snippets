package snippets.jdk.util.collection.map.hashmap.weakhashmap.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapMain {
    private static Map<String, String> map;
    public static void main (String args[]) {                
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
        
        Runnable runner = new Runnable() {
            public void run() {
                int c = 0;
                while (map.size() > 2) {
                    c = c + 100;
                    try {
                        Thread.sleep(c);
                    } catch (InterruptedException ignored) {
                        ignored.printStackTrace();
                    }
                    System.out.println(c + " size=" + map.size());
                    // s1, s2 will prevent the key from being discarded by the garbage collector
                    System.gc();
                }
            }
        };

        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main joining");
        try {
            t.join();
            System.out.println("Main joined");
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        System.out.println(map);
    }
}
