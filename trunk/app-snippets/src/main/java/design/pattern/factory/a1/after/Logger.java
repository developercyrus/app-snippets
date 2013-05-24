package design.pattern.factory.a1.after;

public interface Logger {
    public void debug(String message);
    public void info(String message);
    public void warn(String message);
    public void error(String message);
}