package snippets.jdk.lang.basics.primitive.pitfall.a1;

public class MainForLong {
    public static void main(String[] args) {
        System.out.println(abnormal());
        
        System.out.println(normal());
    }
    
    public static long abnormal() {
        return 90 * 24 * 3600 * 1000;
    }
    
    public static long normal() {
        return 90L * 24 * 3600 * 1000;
    }
    
}
