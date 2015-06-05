package com.liyi.trackmanage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.liyi.trackmanage.entity.Talk;


public class ManageTest {
	
	@Test
	public void testTalkManage(){
		Talk talk1 = new Talk("Accounting-Driven Development 15min");
		Talk talk2 = new Talk("Accounting-Driven Development 25min");
		Talk talk3 = new Talk("Accounting-Driven Development 35min");
		Talk talk4 = new Talk("Accounting-Driven Development 45min");
		Talk talk5 = new Talk("Accounting-Driven Development 20min");
		Talk talk6 = new Talk("Accounting-Driven Development 30min");
		List<Talk> talks = new ArrayList<Talk>();
		talks.add(talk1);
		talks.add(talk2);
		talks.add(talk3);
		talks.add(talk4);
		talks.add(talk5);
		talks.add(talk6);
		
		int sumTime = 100;
		List<Talk> result  =new TrackManage().executeTalk(talks, sumTime);
		Assert.assertEquals(15, result.get(0).getUseTime());
		Assert.assertEquals(35, result.get(1).getUseTime());
		Assert.assertEquals(20, result.get(2).getUseTime());
		Assert.assertEquals(30, result.get(3).getUseTime());
		
	}
	
	@Test
	public void testSumTimeFromTalks(){
		Talk talk1 = new Talk("Accounting-Driven Development 15min");
		Talk talk2 = new Talk("Accounting-Driven Development 25min");
		Talk talk3 = new Talk("Accounting-Driven Development 35min");
		Talk talk4 = new Talk("Accounting-Driven Development 45min");
		List<Talk> talks = new ArrayList<Talk>();
		talks.add(talk1);
		talks.add(talk2);
		talks.add(talk3);
		talks.add(talk4);
		Assert.assertEquals(120, new TrackManage().getUseTimeFromTalks(talks));
	}

}
