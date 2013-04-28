package snippets.jdk.reflection.field.a1;

import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws Exception {
        MyClass o = new MyClass();
        Field field = MyClass.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(o, "Hello World");
        System.out.println(field.get(o));
    }
}