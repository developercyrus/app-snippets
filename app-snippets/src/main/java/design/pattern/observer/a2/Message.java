package design.pattern.observer.a2;

import java.util.Date;

public class Message {
    private String content;
    private Date arriveDate;
    
    public Message(String content, Date arriveDate) {
        this.content = content;
        this.arriveDate = arriveDate;
    }
     
    public String getContent() {
        return content;
    }
    
    public Date getArriveDate() {
        return arriveDate;
    }
    
    public String toString() {
        return content + " arrived at " + arriveDate;        
    }
}
