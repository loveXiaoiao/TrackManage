package com.liyi.trackmanage.util;


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

}
