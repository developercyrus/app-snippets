package design.pattern.composite.a4;

public class Main {
    public static void main(String[] args) {
        Sales sales1 = new Sales("Bertha", 35000);
        sales1.add(new Sales("Cyrus", 25000));
        sales1.add(new Sales("J Wang", 20000));

        Sales sales2 = new Sales("Eric", 40000);
        sales2.add(new Sales("Brad", 28000));
        sales2.add(new Sales("Elsa", 32000));
        
        Sales sales3 = new Sales("Susan", 60000);
        sales3.add(sales1);
        sales3.add(sales2);
        
        System.out.println(sales1.getCommission());
        System.out.println(sales2.getCommission());
        System.out.println(sales3.getCommission());
    }
}
