package snippets.jdk.jni.a2;

import java.io.File;
import java.io.IOException;

public class HelloWorld {
    native String fromC(); //Make the virtual machine aware of a function defined externally, named "helloFromC"
    
    static {
        String path = (new File(HelloWorld.class.getResource("").getPath())).getAbsolutePath();     
        String library = "snippets.jdk.jni.a2.HelloWorldFromC"; //dll name without extension
        File lib = new File(path + "/" + System.mapLibraryName(library));
        String archDataModel = System.getProperty("sun.arch.data.model");
        System.out.println("OS: " + archDataModel + "bit version");
        System.load(lib.getAbsolutePath());        
    }
    
    public static void main(String argv[]) throws IOException {
        HelloWorld h = new HelloWorld();
        String s = h.fromC();
        System.out.println(s);        
    }
}