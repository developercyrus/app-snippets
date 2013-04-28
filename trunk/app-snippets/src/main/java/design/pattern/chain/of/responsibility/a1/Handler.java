package design.pattern.chain.of.responsibility.a1;

public class Handler { 
    private Handler successor;

    public Handler setSuccessor(Handler successor) { 
        this.successor = successor; 
        return successor;
    }

    public Handler getSuccessor() { 
        return successor; 
    }

    public void handleRequest(char c) { 
        if(successor != null) {
            successor.handleRequest(c);
        }
    } 
}  