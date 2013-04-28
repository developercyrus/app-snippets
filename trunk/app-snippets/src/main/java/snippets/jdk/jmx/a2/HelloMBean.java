package snippets.jdk.jmx.a2;

public interface HelloMBean {
    public long getUptimeMillis();
    public long getCount();
    public void setCount(long val);
    public void printStuff(String stuff);
    public void printCount();
    
}