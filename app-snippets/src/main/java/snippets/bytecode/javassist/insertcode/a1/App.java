package snippets.bytecode.javassist.insertcode.a1;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class App {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("snippets.jdk.lang.instrument.a1.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"before\");}");
        m.insertAfter("{ System.out.println(\"after\");}");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
    }
}
