package snippets.jdk.util.collection.bitset.a1;

import java.util.BitSet;

public class Changer {
    public static int bitSetToInt(BitSet bitSet) {
        int bitInteger = 0;
        for(int i = 0 ; i < 32; i++)
            if(bitSet.get(i))
                bitInteger |= (1 << i);
        return bitInteger;
    }
    
    public static void main(String[] args) {
        BitSet a = new BitSet();
        BitSet b = new BitSet();
        
        //1100
        a.set(2);
        a.set(3);
        
        //1010
        b.set(1);
        b.set(3);
        
        b.and(a);
        System.out.println(b);
        System.out.println(bitSetToInt(b));
    }
}
