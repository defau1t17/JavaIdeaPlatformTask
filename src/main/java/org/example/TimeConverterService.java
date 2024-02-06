package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeConverterService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");


    public String convertSecondsToNormalTime(long seconds) {
        return String.format("%s hour(s) : %s min(s)",
                seconds / 3600,
                (seconds % 3600) / 60);
    }

    public Long getDifferenceBetweenTimes(String date1, String date2) {
        try {
            return (DATE_FORMAT.parse(date1).getTime() - DATE_FORMAT.parse(date2).getTime()) / 1000;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
