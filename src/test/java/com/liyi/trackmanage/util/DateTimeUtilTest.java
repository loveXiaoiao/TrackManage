package com.liyi.trackmanage.util;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author liyi
 * @date 2015年5月31日
 * @desc 
 */
public class DateTimeUtilTest {
    
	@Test
	public void testMorningMinutesParse(){
		Assert.assertEquals("10:05AM", DateTimeUtil.parseMinutes(605, "AM"));
	}
	@Test
	public void testAfternoonMinutesParse(){
		Assert.assertEquals("03:05PM", DateTimeUtil.parseMinutes(185, "PM"));
	}
	
	@Test
	public void testMinAdd2Time(){
		Date d = new Date("Mon 6 Jan 1997 8:3:00");
		Assert.assertEquals("08:53 AM", DateTimeUtil.addMinute2Time(d, 50));
	}

}
