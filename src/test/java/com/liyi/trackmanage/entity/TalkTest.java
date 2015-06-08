package com.liyi.trackmanage.entity;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author liyi
 * @date 2015年5月31日
 * @desc Test for Talk
 */
public class TalkTest {
	
	@Test
	public void testInitTalk(){
		Talk talk = new Talk("Accounting-Driven Development 45min");
		Assert.assertEquals(45, talk.getTalkLength());
        testLightingTalk();
	}

    @Test
    public void testLightingTalk() {
        Talk talk1 = new Talk("Accounting-Driven Development lightning");
        Assert.assertEquals(5, talk1.getTalkLength());
    }

    @Test
    public void testInvalidTalk() {
    	Talk talk = new Talk("Accounting-Driven Development smin");
    	Assert.assertEquals(0, talk.getTalkLength());
    }

}
