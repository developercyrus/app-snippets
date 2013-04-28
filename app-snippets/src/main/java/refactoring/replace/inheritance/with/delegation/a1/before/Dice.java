package refactoring.replace.inheritance.with.delegation.a1.before;

import java.util.Random;

public class Dice extends Random {
    public Dice() {
        super(314159L);        
    }
    
    @Override
    public int nextInt() {
        return nextInt(6) + 1;
        
    }
    
    @Override
    public void nextBytes(byte[] bytes) {
        throw new UnsupportedOperationException();                
    }
    
    @Override
    public long nextLong() {
        throw new UnsupportedOperationException();        
    }
    
    @Override
    public boolean nextBoolean() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public float nextFloat() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public double nextDouble() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public double nextGaussian() {
        throw new UnsupportedOperationException();
    }
}