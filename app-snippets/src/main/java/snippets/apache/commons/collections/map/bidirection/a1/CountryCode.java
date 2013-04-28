package snippets.apache.commons.collections.map.bidirection.a1;

import org.apache.commons.collections.bidimap.DualHashBidiMap;

public class CountryCode extends DualHashBidiMap {
    private static final long serialVersionUID = -3319693626729424867L;

    public CountryCode() {
        super();
        this.put("to","Tonga");
        this.put("tr","Turkey");
        this.put("tv","Tuvalu");
        this.put("tz","Tanzania");
        this.put("ua","Ukraine");
        this.put("ug","Uganda");
        this.put("uk","United Kingdom");
        this.put("um","USA Minor Outlying Islands");
        this.put("us","United States");
    }
}
