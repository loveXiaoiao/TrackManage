package com.liyi.trackmanage.util;

public class DateTimeUtil {
    public static String parseMinutes(int time, String mode) {
        int hours = time / 60;
        int minutes = time % 60;

        String hourHint = hours < 10 ? "0" : "";
        String minuteHint = minutes < 10 ? "0" : "";
        return hourHint + hours + ":" + minuteHint + minutes + mode;
    }
}