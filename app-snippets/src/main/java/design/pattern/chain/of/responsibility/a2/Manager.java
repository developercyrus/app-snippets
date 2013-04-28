package design.pattern.chain.of.responsibility.a2;

public class Manager extends Role {
    private final double ALLOWABLE = 10 * base;

    public void processRequest(PurchaseRequest request ) {
        if( request.getAmount() < ALLOWABLE ) {
            System.out.println("Manager will approve $"+ request.getAmount());
        }
        else {
            if( successor != null)
                successor.processRequest(request);
        }
    }
}
