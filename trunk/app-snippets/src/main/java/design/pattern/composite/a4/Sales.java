package design.pattern.composite.a4;

import java.util.ArrayList;
import java.util.List;

public class Sales {
    private String name;
    private double revenue;
    private List<Sales> list;
    
    public Sales(String name, double revenue) {
        this.list = new ArrayList<Sales>();
        this.name = name;
        this.revenue = revenue;
    }
    
    public String getName() {        
        return name;
    }
    
    public double getCommission() {    
        double commission = revenue * 0.1;
        //System.out.println(name + " " + commission);
        for (Sales s : list) {
            commission += s.getCommission();
        }
        return commission;
    }
    
    public void add(Sales sales) {
        list.add(sales);
    }
    
}
