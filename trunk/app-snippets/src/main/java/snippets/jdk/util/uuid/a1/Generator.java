package snippets.jdk.util.uuid.a1;

import java.util.UUID;

public class Generator {
    public static void main(String[] args) {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        
        System.out.println(id1.toString());
        System.out.println(id2.toString());
    }
    
}
