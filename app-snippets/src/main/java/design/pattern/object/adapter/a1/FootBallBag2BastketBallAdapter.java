package design.pattern.object.adapter.a1;

public class FootBallBag2BastketBallAdapter extends BasketBallBag {
    FootBallBag fb;
    
    public FootBallBag2BastketBallAdapter(FootBallBag fb) {
        this.fb = fb;
    }
    
    @Override
    public void putBasketBall() {
        fb.putFootBall();
    }
} 
