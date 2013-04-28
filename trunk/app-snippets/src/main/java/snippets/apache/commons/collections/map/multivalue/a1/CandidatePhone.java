package snippets.apache.commons.collections.map.multivalue.a1;

import org.apache.commons.collections.map.MultiValueMap;

public class CandidatePhone extends MultiValueMap {
    public CandidatePhone() {
        super();
        this.put("John", "98661234");
        this.put("Mary", "97131212");
        this.put("Mary", "92124578");
        this.put("John", "96541789");
    }
}
