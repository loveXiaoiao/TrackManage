package com.liyi.trackmanage.service;

import com.liyi.trackmanage.entity.Session;
import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import com.liyi.trackmanage.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyi
 * @date 2015年6月1日
 * @desc Track操作
 */
public class TrackManage {
    private List<Talk> unUsedTalk = new ArrayList<Talk>();//静态变量，未使用的会议主题
    private List<Track> tracks = new ArrayList<Track>();

    public List<Track> getTracks(List<Talk> talks) {
        unUsedTalk = talks;
        int trackNum = getTotalLength(talks) / Constant.DAY_LENGTH + 1;

        for (int i = 0; i < trackNum; i++) {
            Track track = new Track(Constant.TRACK + " " + (i + 1));
            track.setMorningSession(new Session(executeTalk(Constant.MORNING_SESSION_LENGTH)));

            if (getTotalLength(unUsedTalk) > 0) {
                track.setAfternoonSession(new Session(executeTalk(Constant.AFTERNOON_SESSION_LENGTH)));
            }
            tracks.add(track);
        }
        return tracks;
    }

    protected List<Talk> executeTalk(int maxTime) {
        int[] talkLength = getAllLengths(unUsedTalk);

        int resultArray[] = new Knapsack(talkLength, talkLength, maxTime).execute();

        List<Talk> tmpTalks = new ArrayList<Talk>();
        List<Talk> talkList = new ArrayList<Talk>();
        
        for (int j = 0; j < resultArray.length; j++) {
            if (resultArray[j] == 1) {
                talkList.add(unUsedTalk.get(j));
            } else {
                tmpTalks.add(unUsedTalk.get(j));
            }
        }
        unUsedTalk = tmpTalks;
        return talkList;
    }
    
    private int[] getAllLengths(List<Talk> talks) {
        int[] talkLengths = new int[talks.size()];
        for (int i = 0; i < talks.size(); i++) {
            talkLengths[i] = talks.get(i).getTalkLength();
        }

        return talkLengths;
    }

    protected int getTotalLength(List<Talk> talks) {
        int sum = 0;
        for (Talk talk : talks) {
            sum = sum + talk.getTalkLength();
        }
        return sum;
    }

}
