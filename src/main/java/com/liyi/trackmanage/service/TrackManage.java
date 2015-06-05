package com.liyi.trackmanage.service;

import com.liyi.trackmanage.entity.Session;
import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import com.liyi.trackmanage.util.Constant;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author liyi
 * @date 2015年6月1日
 * @desc Track操作
 */
public class TrackManage {
	private static List<Talk> unUsedTalk = new ArrayList<Talk>();//静态变量，未使用的会议主题
    private List<Track> tracks = new ArrayList<Track>();

    /**
     * 
     * @param talks
     * @return
     */
    public List<Track> getTracks(List<Talk> talks) {
        unUsedTalk = talks;
        int trackNum = getUseTimeFromTalks(talks) / Constant.DAY_LENGTH + 1;
        
        for (int i = 0; i < trackNum; i++) {
            Track track = new Track(Constant.TRACK + " " + (i + 1));

            Session morningSession = arrangeSessionTalks(unUsedTalk, Constant.MORNING_SESSION_LENGTH);
            track.setMorningSession(morningSession);
            
            if (getUseTimeFromTalks(unUsedTalk) > 0) {
                Session afternoonSession = arrangeSessionTalks(unUsedTalk, Constant.AFTERNOON_SESSION_LENGTH);
                track.setAfternoonSession(afternoonSession);
            }
            tracks.add(track);
        }
		return tracks;
	}
    
    private Session arrangeSessionTalks(List<Talk> unUsedTalks, int sessionLength) {
        Session session = new Session();
        List<Talk> sessionTalks = executeTalk(unUsedTalks, sessionLength);
        session.setTalks(sessionTalks);
        return session;
    }
    

	/**
	 * 
	 * @param talks
	 * @param maxTime
	 * @return
	 * @desc 对一个时间段进行会议选择，取出最优
	 */
	public List<Talk> executeTalk(List<Talk> talks, int maxTime) {
		int talkLength[] = new int[talks.size()];
		List<Talk> talkList = new ArrayList<Talk>();
		for (int i = 0; i < talks.size(); i++) {
			talkLength[i] = talks.get(i).getUseTime();
		}
		List<Talk> tmpTalks = new ArrayList<Talk>();
		Knapsack ks = new Knapsack(talkLength, talkLength, maxTime);
		int resultArray[] = ks.execute();
		for (int j = 0; j < resultArray.length; j++) {
			if (resultArray[j] == 1) {// 使用的元素
				talkList.add(talks.get(j));
			}
			if (resultArray[j] == 0) {// 未被使用的元素
				tmpTalks.add(talks.get(j));
			}
		}
		unUsedTalk = tmpTalks;
		return talkList;

	}
	
	public int getUseTimeFromTalks(List<Talk> talks) {
		int sum = 0;
		for (Talk talk : talks) {
			sum = sum + talk.getUseTime();
		}
		return sum;
	}

}
