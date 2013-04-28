package design.pattern.visitor.a5.after;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<RecordType> lists = new ArrayList<RecordType>();
        lists.add(new RecordType1());
        lists.add(new RecordType2());
        
        Processor processor = new Processor();
        
        for (RecordType recordType : lists) {
            String result = (String) recordType.accept(processor);
            System.out.println(result);
        }
    }
}
