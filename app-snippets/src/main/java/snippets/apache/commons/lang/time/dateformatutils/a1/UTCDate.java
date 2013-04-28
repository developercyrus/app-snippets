package snippets.apache.commons.lang.time.dateformatutils.a1;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class UTCDate {
    public static void main(String[] args) throws Exception {
        Date now = new Date();
        System.out.println("now: " + DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(now));
        System.out.println("UTC Time: " + DateFormatUtils.formatUTC(now, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern()));
    }
}
