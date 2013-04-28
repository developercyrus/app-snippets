package design.pattern.strategy.a2.before;

public class Main {
    public static void main(String[] args) {
        Character character1 = new Human("Lawrence");
        Character character2 = new Dwarve("Tony");
        
        character1.attack();
        character2.attack();       
    }
}
