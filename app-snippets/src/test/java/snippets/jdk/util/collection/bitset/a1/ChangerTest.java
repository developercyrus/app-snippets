package snippets.jdk.util.collection.bitset.a1;

import static org.junit.Assert.assertEquals;

import java.util.BitSet;

import org.junit.Test;

public class ChangerTest {
    @Test
    public void testAnd() {
        BitSet a = new BitSet();
        BitSet b = new BitSet();
        
        //1100
        a.set(2);
        a.set(3);
        
        //1010
        b.set(1);
        b.set(3);
                
        a.and(b);
        int actual = Changer.bitSetToInt(a);
        //1000
        int expected = 8;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testOr() {
        BitSet a = new BitSet();
        BitSet b = new BitSet();
        
        //1100
        a.set(2);
        a.set(3);
        
        //1010
        b.set(1);
        b.set(3);
                
        a.or(b);
        int actual = Changer.bitSetToInt(a);
        //1110
        int expected = 14;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testXor() {
        BitSet a = new BitSet();
        BitSet b = new BitSet();
        
        //1100
        a.set(2);
        a.set(3);
        
        //1010
        b.set(1);
        b.set(3);
                
        a.xor(b);
        int actual = Changer.bitSetToInt(a);
        //0110
        int expected = 6;
        
        assertEquals(expected, actual);
    }
}
