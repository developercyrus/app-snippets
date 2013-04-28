package design.pattern.visitor.a5.before;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public RecordType process(RecordType record) throws Exception{
        if (record instanceof RecordType1)
            return process((RecordType1) record);
        else if (record instanceof RecordType2)
            return process((RecordType2) record);

        throw new Exception();
    }

    private RecordType1 process(RecordType1 record){        
        return record;
    }

    private RecordType2 process(RecordType2 record){
        return record;        
    }
    
    public static void main(String[] args) throws Exception {
        List<RecordType> lists = new ArrayList<RecordType>();
        lists.add(new RecordType1());
        lists.add(new RecordType2());
        
        Main main = new Main();
        for (RecordType recordType : lists) {
            main.process(recordType);
        }
    }
}
