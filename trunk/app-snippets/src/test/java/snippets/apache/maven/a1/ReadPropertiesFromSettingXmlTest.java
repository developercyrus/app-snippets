package snippets.apache.maven.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class ReadPropertiesFromSettingXmlTest {
    /*
     * Properties are read from ~/.m2/settings.xml
     * If executing mvn directly, it will should read the value by System.getProperty in Java code (not yet verified)
     * 
     * But the maven-surefire-plugin will clear all system properties. 
     * So if running all JUnit tests by executing maven-test in eclipse, it will return null value
     * To resolve it, it has to "export" to system properties by using <systemProperties>
     * referece: http://maven.apache.org/plugins/maven-surefire-plugin/examples/system-properties.html
     * 
     *   <?xml version="1.0" encoding="UTF-8"?>
     *   <settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.0.0"
     *       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">   
     *       <profiles>
     *           <profile> 
     *               <id>someProf</id> 
     *               <activation> 
     *                   <activeByDefault/> 
     *               </activation> 
     *               <properties> 
     *                   <server.username>username1</server.username> 
     *                   <server.password>password1</server.password>
     *               </properties> 
     *           </profile> 
     *       </profiles>     
     *       <activeProfiles>
     *           <activeProfile>someProf</activeProfile>
     *       </activeProfiles>
     *   </settings>
     *   
     */

    @Test
    public void test() {
        assertEquals("username1", ReadPropertiesFromSettingXml.getUsername());
        assertEquals("password1", ReadPropertiesFromSettingXml.getPassword());
    }

    @Ignore
    @Test
    public void test2() {
        assertEquals("C:\\jdk\\jdk1.6.0_25", ReadPropertiesFromSettingXml.getJavaHome());
    }
}
