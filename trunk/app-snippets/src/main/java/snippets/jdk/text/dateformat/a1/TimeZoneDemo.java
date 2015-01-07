package snippets.jdk.text.dateformat.a1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneDemo {
    public static void main(String ... args) {
        Calendar cal = new GregorianCalendar();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        TimeZone timeZone1 = TimeZone.getTimeZone("GMT+8");
        TimeZone timeZone2 = TimeZone.getTimeZone("GMT-8");
    
        formatter.setTimeZone(timeZone1);
        cal.setTimeZone(timeZone1);
        System.out.println(formatter.format(cal.getTime()));
        
        formatter.setTimeZone(timeZone2);
        cal.setTimeZone(timeZone2);
        System.out.println(formatter.format(cal.getTime()));
    }
}
