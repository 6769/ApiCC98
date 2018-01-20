package win.pipi.api.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final String DATE_FORMAT="yyyy-MM-dd'T'hh:mm:ss.S";

    public static Date convertAPIDate(String ts) throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
        return dateFormatter.parse(ts);

    }


    private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd hh:mm";
    public static String getDefaultDateStr(String ts){
        SimpleDateFormat DEFAULT_FORMAT=new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date postdate;
        try {
            postdate=convertAPIDate(ts);
        }catch (Exception e){
            postdate=new Date();
        }
        return DEFAULT_FORMAT.format(postdate);



    }
}
