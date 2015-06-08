package com.liyi.trackmanage.service;

import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


public class TrackManageTest {

    private List<Talk> talks;

    @Before
    public void setUp() throws Exception {
        talks = newArrayList(
                new Talk("Accounting-Fool Development 15min"),
                new Talk("GongMing-d-Fool Dev 95min"),
                new Talk("Java-Dou-Bi Development 85min"),
                new Talk("LiYi-Good-Boy Development 45min"),
                new Talk("LaoJiu-Pretty-Girl Development 120min"),
                new Talk("Ruby Learning Development 130min")
        );

    }

    @Test
    public void testGetTrackNum() {

        List<Track> result = new TrackManage().getTracks(talks);
        Assert.assertEquals(2, result.size());

    }
    
    @Test
    public void testFirstTrackShoulBe(){
        List<Track> result = new TrackManage().getTracks(talks);
        Assert.assertEquals("Accounting-Fool Development 15min", result.get(0).getMorningSession().getTalks().get(0).getTitle());
        Assert.assertEquals("Accounting-Fool Development 15min", result.get(0).getMorningSession().getTalks().get(1).getTitle());

    }

    @Test
    public void testSumTimeFromTalks() {
        Talk talk1 = new Talk("Accounting-Driven Development 15min");
        Talk talk2 = new Talk("Accounting-Driven Development 25min");
        Talk talk3 = new Talk("Accounting-Driven Development 35min");
        Talk talk4 = new Talk("Accounting-Driven Development 45min");
        List<Talk> talks = new ArrayList<Talk>();
        talks.add(talk1);
        talks.add(talk2);
        talks.add(talk3);
        talks.add(talk4);
        Assert.assertEquals(120, new TrackManage().getTotalLength(talks));
    }

}
