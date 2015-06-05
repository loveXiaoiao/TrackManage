package com.liyi.trackmanage.entity;


import org.junit.Assert;
import org.junit.Test;

public class TrackTest {
	
	@Test
	public void testGetTrackName(){
		Track track = new Track("Track1");
		Assert.assertEquals("Track1", track.getName());
	}

}
