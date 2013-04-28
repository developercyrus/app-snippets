package design.pattern.strategy.a1;

public class Main { 
    public static void main(String[] args) { 
        String linuxText = "This is a test text!!@n Oh! Line Return!!@n"; 
        String windowsText = "This is a test text!!@r@n Oh! Line Return@r@n"; 

        TextCharChange.replace(new WindowsStrategy(linuxText)); 
        TextCharChange.replace(new LinuxStrategy(windowsText)); 
    } 
} 
