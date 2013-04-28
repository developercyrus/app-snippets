package design.pattern.object.adapter.a1;

public class Main {
    public static void main(String[] args){
        
        /*
         * Target - BasketBallBag 
         * Adapter - FootBallBag2BastketBallAdapter 
         * Adaptee -FootBallBag
         */
        
        BasketBallBag bb = new BasketBallBag();         
        FootBallBag fb = new FootBallBag(); 
        
        BallCollector bc = new BallCollector();                        
        bc.putBall(bb);   
                           
        FootBallBag2BastketBallAdapter fba = new FootBallBag2BastketBallAdapter(fb);   
        bc.putBall(fba); 
    }
}