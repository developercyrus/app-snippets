package snippets.jdk.util.collection.list.frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountDuplicatedList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("\nExample 1 - Count 'a' with frequency");
        System.out.println("a : " + Collections.frequency(list, "a"));

        System.out.println("\nExample 2 - Count all with frequency");
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }

        System.out.println("\nExample 3 - Count all with Map");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String temp : list) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}