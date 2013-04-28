package snippets.jdk.util.zip.a1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class ReadingJarFile2 {
    List<String> fileList = new ArrayList<String>();
    
    public ReadingJarFile2() throws IOException, ClassNotFoundException {
        String jarFilename = this.getClass().getResource("SIA.Util.jar").getFile();
        File file  = new File(jarFilename);
        URL url = file.toURL();  
        URL[] urls = new URL[]{url};
        ClassLoader cl = new URLClassLoader(urls);
        Class cls = cl.loadClass("SIA.Util.StrEncrypt");
        
        System.out.println("===methods===");
        Method[] ms = cls.getDeclaredMethods();
        for (Method m: ms) {
            System.out.println(m.getName());
        }
        
        System.out.println("===fields===");
        Field[] fs = cls.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f.getName() + "\t" + f.getType().getName());
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new ReadingJarFile2();
    }
    
  
}
