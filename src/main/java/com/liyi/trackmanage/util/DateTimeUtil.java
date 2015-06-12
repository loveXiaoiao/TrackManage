package com.liyi.trackmanage.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    public static String parseMinutes(int time, String mode) {
        int hours = time / 60;
        int minutes = time % 60;

        String hourHint = hours < 10 ? "0" : "";
        String minuteHint = minutes < 10 ? "0" : "";
        return hourHint + hours + ":" + minuteHint + minutes + mode;
    }
    
    
    public static String addMinute2Time(Date date, int min){
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.MINUTE, min);
    	Date resultDate = cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a", Locale.ENGLISH);// 格式化时间  
    	return sdf.format(resultDate);
    }
}