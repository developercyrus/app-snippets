package design.pattern.chain.of.responsibility.a1;

public class CharacterHandler extends Handler { 
    public void handleRequest(char c) { 
        if(Character.isLetter(c)) { 
            System.out.println("Character has been handled"); 
        } 
        else {
            System.out.println("not character.");
            getSuccessor().handleRequest(c); 
        }
    } 
}  
