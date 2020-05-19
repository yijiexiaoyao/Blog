package tech.acodesigner.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 *
 */
public class DateUtil {

    public static String formatLong(long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(date);
    }
}
