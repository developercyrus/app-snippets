package snippets.jdk.lang.system.properties.a1;

import java.util.Map;

public class ShowAllProperties {
    public static void main(String[] args) {
        for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
            System.out.println(e);
        }
    }
}
