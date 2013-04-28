package design.pattern.chain.of.responsibility.a2;

public class Main  {
    public static void checkAuthority(double amount){
        Manager manager = new Manager();
        Director director = new Director();
        VicePresident vicepresident = new VicePresident();
        President president = new President();
        
        manager.setSuccessor(director);
        director.setSuccessor(vicepresident);
        vicepresident.setSuccessor(president);
        
        manager.processRequest(new PurchaseRequest(0, amount, "General"));
    }
    
    public static void main(String[] args) {
        checkAuthority(5001);
    }
}    
