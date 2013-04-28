package snippets.apache.maven.a1;

public class ReadPropertiesFromSettingXml {
    public static String getUsername() {
        return System.getProperty("server.username");
    }
    
    public static String getPassword() {
        return System.getProperty("server.password");
    }

    public static String getJavaHome() {
        return System.getProperty("java.home");
    }
}
