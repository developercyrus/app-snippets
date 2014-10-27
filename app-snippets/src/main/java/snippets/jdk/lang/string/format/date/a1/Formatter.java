package snippets.jdk.lang.string.format.date.a1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    
    public static void main(String[] args) throws ParseException {
        
        String dateStart = "2014-10-27 13:56:58.760";        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date d1 = format.parse(dateStart);
        
        System.out.println(String.format("%tF", d1)); 
        System.out.println(String.format("%tH", d1));   //hour
        System.out.println(String.format("%tM", d1));   //minute
        System.out.println(String.format("%tS", d1));   //second
        System.out.println(String.format("%tL", d1));   //nano second
    }
}
