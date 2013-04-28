package design.pattern.decorator.a3;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        
        computer = new Disk(computer);
        computer = new CD(computer);
        computer = new Monitor(computer);
        
        System.out.println("You're getting a " + computer.description());
    }
}
