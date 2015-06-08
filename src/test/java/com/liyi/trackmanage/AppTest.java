package com.liyi.trackmanage;

import com.liyi.trackmanage.entity.Session;
import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Unit test for simple App.
 *
 * @author liyi
 */
public class AppTest {
    private App app;
    
    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testTracksToString() {

        Track track = new Track("Track1");
        Session morningSession = new Session(newArrayList(
                new Talk("Accounting-Driven Development 15min"),
                new Talk("Accounting-Driven Development 25min"),
                new Talk("Accounting-Driven Development 35min")));
        Session afternoonSession = new Session(newArrayList(
                new Talk("Accounting-Driven Development 45min"),
                new Talk("Accounting-Driven Development 20min"),
                new Talk("Accounting-Driven Development 30min")));
        track.setMorningSession(morningSession);
        track.setAfternoonSession(afternoonSession);

        List<Track> tracks = newArrayList(track);
        String result = app.parseTracksToString(tracks);
        Assert.assertEquals(true, result.contains("09:00AM Accounting-Driven Development 15min"));
    }

    @Test
    public void testParseToTalks() {
        List<String> list = newArrayList(
                "Accounting-Driven Development 15min",
                "Accounting-Driven Development 25min",
                "Accounting-Driven Development 35min",
                "Accounting-Driven Development 45min",
                "Accounting-Driven Development 30min");
        Assert.assertEquals(15, app.parseToTalks(list).get(0).getTalkLength());
    }
}
