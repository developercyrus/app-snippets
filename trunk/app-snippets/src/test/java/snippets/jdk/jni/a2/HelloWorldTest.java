package snippets.jdk.jni.a2;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class HelloWorldTest {
    /*
        unresolved yet
    
        java.lang.UnsatisfiedLinkError: Can't load library: D:\eclipse_workspace_4.2\app-snippets\target\test-classes\snippets\jdk\jni\a2\snippets.jdk.jni.a2.HelloWorldFromC.dll
        at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1854)
        at java.lang.Runtime.load0(Runtime.java:795)
        at java.lang.System.load(System.java:1062)
        at snippets.jdk.jni.a2.HelloWorld.<clinit>(HelloWorld.java:14)
        at snippets.jdk.jni.a2.HelloWorldTest.test(HelloWorldTest.java:11)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:606)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
        at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
        at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
        at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
        at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
        at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
        at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
        at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
        at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
        at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)
        at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)
        at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)
        at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)

     */
    
    @Ignore
    @Test
    public void test() {
        HelloWorld h = new HelloWorld();
        String expected = "Hello World! This is from C.";
        String actual = h.fromC();
              
        assertEquals(expected, actual);
    }
}
