package com.liyi.trackmanage;

import com.liyi.trackmanage.entity.Session;
import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import com.liyi.trackmanage.util.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 * @author liyi
 */
public class AppTest 
{
	@Test
	public void testTracksToString(){
		Talk talk1 = new Talk("Accounting-Driven Development 15min");
		Talk talk2 = new Talk("Accounting-Driven Development 25min");
		Talk talk3 = new Talk("Accounting-Driven Development 35min");
		Talk talk4 = new Talk("Accounting-Driven Development 45min");
		Talk talk5 = new Talk("Accounting-Driven Development 20min");
		Talk talk6 = new Talk("Accounting-Driven Development 30min");
		List<Talk> talks1 = new ArrayList<Talk>();
		List<Talk> talks2 = new ArrayList<Talk>();
		talks1.add(talk1);
		talks1.add(talk2);
		talks1.add(talk3);
		talks2.add(talk4);
		talks2.add(talk5);
		talks2.add(talk6);
		
		Track track = new Track("Track1");
		Session morningSession = new Session();
		Session afternoonSession = new Session();
		morningSession.setTalks(talks1);
		afternoonSession.setTalks(talks2);
		track.setMorningSession(morningSession);
		track.setAfternoonSession(afternoonSession);
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(track);
		App app = new App();
		String result = app.parseTracksToString(tracks);
		Assert.assertEquals(true, result.contains("09:00AM Accounting-Driven Development 15min"));
		
		
	}
	
	@Test
	public void testParseToTalks(){
		List<String> list = new ArrayList<String>();
		list.add("Accounting-Driven Development 15min");
		list.add("Accounting-Driven Development 25min");
		list.add("Accounting-Driven Development 35min");
		list.add("Accounting-Driven Development 45min");
		list.add("Accounting-Driven Development 30min");
		App app = new App();
		Assert.assertEquals(15, app.parseToTalks(list).get(0).getUseTime());
		
	}
	
	
}
