package design.pattern.chain.of.responsibility.a2;

public class Director extends Role {
    private final double ALLOWABLE = 20 * base;

    public void processRequest(PurchaseRequest request ) {
        if( request.getAmount() < ALLOWABLE ) {
            System.out.println("Director will approve $"+ request.getAmount());
        }
        else {
            if( successor != null)
                successor.processRequest(request);
        }
    }
}