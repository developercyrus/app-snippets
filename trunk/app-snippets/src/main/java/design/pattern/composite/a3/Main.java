package design.pattern.composite.a3;

public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Bertha", 35000);
        manager1.add(new Subordinate("Cyrus", 25000));
        manager1.add(new Subordinate("J Wang", 20000));

        Manager manager2 = new Manager("Eric", 40000);
        manager2.add(new Subordinate("Brad", 28000));
        manager2.add(new Subordinate("Elsa", 32000));
        
        Manager manager3 = new Manager("Suan", 60000);
        manager3.add(manager1);
        manager3.add(manager2);
        
        manager3.print(0);
    }
}
