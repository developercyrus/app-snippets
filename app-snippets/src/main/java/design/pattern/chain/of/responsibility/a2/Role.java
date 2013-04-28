package design.pattern.chain.of.responsibility.a2;

public abstract class Role {

    protected final double base = 500;
    protected Role successor;

    public void setSuccessor(Role successor){
        this.successor = successor;
    }

    abstract public void processRequest(PurchaseRequest request);
}