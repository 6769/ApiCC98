package win.pipi.api.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final String DATE_FORMAT="yyyy-MM-dd'T'hh:mm:ss.S";

    public static Date convertAPIDate(String ts) throws ParseException {
        return convertAPIDate(ts,DEFAULT_DATE_FORMAT);
    }

    public static Date convertAPIDate(String ts,String fmt) throws ParseException{
        SimpleDateFormat dateFormatter = new SimpleDateFormat(fmt);
        return dateFormatter.parse(ts);
    }


    private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd hh:mm";


    public static String getDateStr(Date date){
        SimpleDateFormat DEFAULT_FORMAT=new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return DEFAULT_FORMAT.format(date);
    }


    public static String getDateStupid(String ts){
        return ts.substring(0,16).replace("T"," ");
    }
}
