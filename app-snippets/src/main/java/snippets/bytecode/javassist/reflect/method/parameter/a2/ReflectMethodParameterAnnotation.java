package snippets.bytecode.javassist.reflect.method.parameter.a2;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class ReflectMethodParameterAnnotation {
    public static void main(String[] args) throws CannotCompileException, InstantiationException, IllegalAccessException {
        testReflectMethodParamAnno();
    }

    public static void testReflectMethodParamAnno() throws CannotCompileException, InstantiationException, IllegalAccessException {
        Class clazz = MyClass.class;
        String[] parameters;
        
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(clazz.getName());
            CtMethod cm = cc.getDeclaredMethod("fomat");
            Object[][] parameterAnnotations = cm.getParameterAnnotations();
            CtClass[] parameterTypes = cm.getParameterTypes();
            
            int i=0;
            for(Object[] annotations : parameterAnnotations){
                CtClass parameterType = parameterTypes[i++];
                for(Object annotation : annotations){
                  if(annotation instanceof DateFormat){
                      DateFormat dateFormat = (DateFormat) annotation;
                      System.out.println("param: " + parameterType.getName());
                      System.out.println("value: " + dateFormat.value());
                  }
                }
              }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
