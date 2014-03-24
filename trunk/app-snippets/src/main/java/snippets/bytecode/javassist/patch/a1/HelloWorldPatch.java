package snippets.bytecode.javassist.patch.a1;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class HelloWorldPatch {
    public static void main(String[] argv) throws Exception{
        /*
         * 1. HelloWorld.class requires a correct serial to display message.
         * 2. HelloWorldPatch patches bytecode of HelloWorld by renaming the original checking  method, and
         *    add a new method that always return true;
         * 3. After patch, it saves to d:/tmp
         */

        //Load the class that we will be patching...
        ClassPool pool = ClassPool.getDefault();
        CtClass klass = pool.get("snippets.bytecode.javassist.patch.a1.HelloWorld");

        //Get the method we want to patch, and rename...
        CtMethod orig = klass.getDeclaredMethod("checkSerial");
        orig.setName( "checkSerial$impl" );

        // Create a new function that will always return true...
        CtMethod patch = CtNewMethod.copy(orig, "checkSerial", klass, null);
        patch.setBody("{ return true; }");

        // Add patched method..
        klass.addMethod( patch );
        //klass.writeFile();
        klass.writeFile("d:/tmp");
        
        System.out.println("Done Patching.");

        CtMethod[] methods = klass.getDeclaredMethods();
        for (int i=0; i<methods.length ; i++) {
            System.out.println( "\t" + methods[i].getLongName());
        }

    }
}