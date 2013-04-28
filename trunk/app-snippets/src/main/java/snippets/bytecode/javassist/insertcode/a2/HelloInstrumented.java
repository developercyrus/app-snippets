package snippets.bytecode.javassist.insertcode.a2;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class HelloInstrumented {
    private String message;
    
    public void setMessage(String message) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("snippets.bytecode.javassist.insertcode.a2.Hello");
        CtMethod m = cc.getDeclaredMethod("setMessage");
        m.insertBefore("{ message = \"Peter, \" + message; }");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.setMessage(message);
        
        this.message = h.getMessage();
    }
    
    public String getMessage() {
        return message;
    }
}
