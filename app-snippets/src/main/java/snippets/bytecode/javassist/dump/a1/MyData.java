package snippets.bytecode.javassist.dump.a1;

import java.util.ArrayList;
import java.util.List;

public class MyData {
    private List<String> strings = new ArrayList<String>();
    private String firstname;
    private int result;
    private int value1;
    private int value2;

    public void add(String str) {
        strings.add(str); 
    }
    
    public void delete(int i) {
        strings.remove(i);
    }
    
    public void getResult(){
        int result = value1 + value2;
    }
}
