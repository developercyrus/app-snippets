package snippets.jdk.lang.runtime;

public class ProcessorCount {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();        
        System.out.println(processors);
    }
}
