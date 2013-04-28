/*
(1) Open a command prompt, and execute the following
java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=2222 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false snippets.jdk.jmx.a2.HelloMBeanServer

(2) Open a second command prompt, and execute jconsole, and remote connect by "localhost:2222", where port 2222 is an arbitray number

*/

package snippets.jdk.jmx.a2;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HelloMBeanServer {
    public static void main(String[] args) throws Exception {
        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
        Hello mbean = new Hello();
 
        ObjectName mbeanName = new ObjectName("myapp:service=MyServer");
        mbeanServer.registerMBean(mbean, mbeanName);
        mbean.run();
    }
}
