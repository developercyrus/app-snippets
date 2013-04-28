package snippets.bytecode.javassist.reflect.method.parameter.a2;

import java.util.Date;

public class MyClass {
    public String fomat(@DateFormat("yyyy-MM-dd hh:mm:ss") Date date1) {
        return date1.toString();
    }
}