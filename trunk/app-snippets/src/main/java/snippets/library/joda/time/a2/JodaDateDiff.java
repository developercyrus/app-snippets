package snippets.library.joda.time.a2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class JodaDateDiff {
    public static void main(String[] args) {
        String dateStart = "2013-02-19 09:29:58";
        String dateStop = "2013-02-20 11:31:48";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            
            System.out.println(dateStart);
            System.out.println(dateStop);
            System.out.print(Days.daysBetween(dt1, dt2).getDays() + " day, ");
            System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hour, ");
            System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minute, ");
            System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " second.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}