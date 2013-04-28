package design.pattern.chain.of.responsibility.a2;

public class VicePresident extends Role {
    private final double ALLOWABLE = 40 * base;

    public void processRequest(PurchaseRequest request) {
        if( request.getAmount() < ALLOWABLE ) {
            System.out.println("Vice President will approve $" + request.getAmount());
        }
        else {
            if( successor != null )
                successor.processRequest(request);
        }
    }
}
