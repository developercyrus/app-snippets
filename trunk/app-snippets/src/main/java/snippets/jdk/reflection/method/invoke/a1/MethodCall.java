package snippets.jdk.reflection.method.invoke.a1;

import java.lang.reflect.Method;

public class MethodCall {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("snippets.jdk.reflection.method.invoke.a1.Person");
        Object obj = cls.newInstance();
        Class parameters1[] = new Class[1];
        parameters1[0] = String.class;
        Class parameters2[] = {};
        
        Method m1 = cls.getMethod("setFirstname", parameters1);
        m1.invoke(obj, "Peter");
        Method m2 = cls.getMethod("getFullname", parameters2);
        System.out.println(m2.invoke(obj));
    }
}
