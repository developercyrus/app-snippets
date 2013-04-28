package design.pattern.chain.of.responsibility.a1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException { 
        NumberHandler nh = new NumberHandler();
        CharacterHandler ch = new CharacterHandler();
        SymbolHandler sh = new SymbolHandler();
        
        nh.setSuccessor(ch);
        ch.setSuccessor(sh);
        
        nh.handleRequest('1');        
        nh.handleRequest('c');
        nh.handleRequest('$');
    } 
}
