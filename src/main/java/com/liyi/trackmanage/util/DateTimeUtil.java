package com.liyi.trackmanage.util;

/**
 * 
 * @author liyi
 * @date 2015年5月31日
 * @desc 时间处理工具类
 */
public class DateTimeUtil
{
	public static String parseMinutes(int time, String mode) {
	    int hours = time / 60;
	    int minutes = time % 60;

        String hourHint = hours < 10 ? "0" : "";
        String minuteHint = minutes < 10 ? "0" : "";
	    return hourHint + hours + ":" + minuteHint + minutes + mode;
	}
	
	
	
}