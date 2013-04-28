package design.pattern.decorator.a3;

public class Main2 {
    public static void main(String[] args) {
        Computer computer = new Monitor(new CD(new Disk(new Computer())));
        
        System.out.println("You're getting a " + computer.description());
    }
}
