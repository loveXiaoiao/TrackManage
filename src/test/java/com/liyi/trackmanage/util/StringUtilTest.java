package com.liyi.trackmanage.util;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author liyi
 * @date 2015年5月30日
 * @desc 
 */
public class StringUtilTest {
	
	@Test
	public void testGetNumFromString(){
		String str = "gwegwe23fwef";
		Assert.assertEquals(23, StringUtil.getNumFromString(str));
	}

}
