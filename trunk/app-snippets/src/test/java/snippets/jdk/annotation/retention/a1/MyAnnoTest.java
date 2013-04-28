package snippets.jdk.annotation.retention.a1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MyAnnoTest {
    private Class<? extends MyAnnoTest> clazz;
    
    @MyAnno(str = "method", val = 300) 
    public static void myMethod() { 
    } 
    
    public static void myParameter(@MyAnno(str = "parameter", val = 200) String a) { 
    } 
    
    @MyAnno(str = "field", val = 100)
    public String myField;
    
    @Before
    public void init() {
        MyAnnoTest ob = new MyAnnoTest();
        clazz = ob.getClass();
    }
    
    @Test
    public void testMethod() throws SecurityException, NoSuchMethodException, NoSuchFieldException {
        Method m = clazz.getMethod("myMethod"); 
        MyAnno anno = m.getAnnotation(MyAnno.class); 
        assertEquals("method", anno.str());
        assertEquals(300, anno.val());
    }
    
    @Test
    public void testParameter() throws SecurityException, NoSuchMethodException, NoSuchFieldException {
        Method declaredMethod = clazz.getDeclaredMethod("myParameter",  new Class[] { String.class });
        Annotation[][] annotations = declaredMethod.getParameterAnnotations(); 
        MyAnno  anno = (MyAnno) annotations[0][0];
        assertEquals("parameter", anno.str());
        assertEquals(200, anno.val());
    }
    
    @Test
    public void testField() throws SecurityException, NoSuchMethodException, NoSuchFieldException {
        Field f = clazz.getField("myField");
        MyAnno anno = f.getAnnotation(MyAnno.class); 
        assertEquals("field", anno.str());
        assertEquals(100, anno.val());
    }
}
