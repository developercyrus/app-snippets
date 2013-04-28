package design.pattern.chain.of.responsibility.a1;

public class NumberHandler extends Handler { 
    public void handleRequest(char c) { 
        if(Character.isDigit(c)) { 
            System.out.println("Number has been handled"); 
        } 
        else {
            System.out.println("not number.");
            getSuccessor().handleRequest(c); 
        }
    } 
}  
