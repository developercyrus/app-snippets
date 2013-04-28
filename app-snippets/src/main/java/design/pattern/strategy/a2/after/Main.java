package design.pattern.strategy.a2.after;

public class Main {
    public static void main(String[] args) {
        /*
         *  http://pro.ctlok.com/blog/2012/03/28/design-pattern-strategy-pattern.html
         */
        
        Character character1 = new Human("Lawrence", new AxeAttackBehavior());
        Character character2 = new Dwarve("Tony", new SwordAttackBehavior());
        
        character1.attack();
        character2.attack();
        
        // selecting algorithm at runtime
        character1.setAttackBehavior(new SwordAttackBehavior());        
        
        character1.attack();
    }
}
