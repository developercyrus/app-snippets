package snippets.jdk.lang.system.properties.a2;

public class GetSetProperties {
    
    public static void set(String key, String value) {
        System.setProperty(key, value);
    }
    
    public static String get(String key) {
        return System.getProperty(key);
    }
 
}
