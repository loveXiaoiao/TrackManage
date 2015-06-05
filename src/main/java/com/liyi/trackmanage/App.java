package com.liyi.trackmanage;

import com.liyi.trackmanage.entity.Talk;
import com.liyi.trackmanage.entity.Track;
import com.liyi.trackmanage.service.TrackManage;
import com.liyi.trackmanage.util.Constant;
import com.liyi.trackmanage.util.DateTimeUtil;
import com.liyi.trackmanage.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liyi
 * @date 2015年5月30日
 * @desc 主程序入口
 */
public class App {

	//设置你的文件路径
    private static final String readFilePath = "/home/liyi/a.txt";
    private static final String writeFilePath = "/home/liyi/b.txt";
    
	public static void main(String[] args) {
        
        App app = new App();
        if(FileUtils.readTxtFile(readFilePath) == null){
        	return;
        }
        List<Talk> talks = app.parseToTalks(FileUtils.readTxtFile(readFilePath));
        if (talks == null) {
            FileUtils.writeStringToFile(writeFilePath, Constant.INPUT_ERROR);
            return;
        }

		List<Track> tracks = new TrackManage().getTracks(talks);
		FileUtils.writeStringToFile(writeFilePath, app.parseTracksToString(tracks));
	}

    public List<Talk> parseToTalks(List<String> list) {
		List<Talk> talks = new ArrayList<Talk>();
		for (String str : list) {
			if ("".equals(str)) {
				continue;
			}
			Talk talk = new Talk(str);
			if (talk.getUseTime() > 0) {
				talks.add(talk);
			} else {
				return null;
			}
		}
		return talks;
	}

	public String parseTracksToString(List<Track> tracks) {
		StringBuilder builder = new StringBuilder();
        
		for (Track trackResult : tracks) {
            builder.append(trackResult.getName()).append(":\n");
            
            int morningStartTime = Constant.MORNING_START_TIME;
            for (Talk talkResult : trackResult.getMorningSession().getTalks()) {
                builder.append(formatTalkString(DateTimeUtil.parseMinutes(morningStartTime, Constant.AM), talkResult.getTitle()));
				morningStartTime += talkResult.getUseTime();
			}
            
            builder.append(formatTalkString(DateTimeUtil.parseMinutes(Constant.LUNCH_TIME, Constant.PM), Constant.LUNCH));

            int afternoonStartTime = Constant.AFTERNOON_START_TIME;
            if (trackResult.getAfternoonSession() != null) {
				for (Talk talkResult : trackResult.getAfternoonSession().getTalks()) {
                    builder.append(formatTalkString(DateTimeUtil.parseMinutes(afternoonStartTime, Constant.PM), talkResult.getTitle()));
					afternoonStartTime = afternoonStartTime + talkResult.getUseTime();
				}
                builder.append(formatTalkString(DateTimeUtil.parseMinutes(Constant.NET_WORKING_TIME, Constant.PM), Constant.NETWORKING));
			}
			builder.append("\n");
		}
		return builder.toString();
	}
    
    private String formatTalkString(String talkTime, String title) {
        return new StringBuilder(talkTime)
                .append(" ")
                .append(title)
                .append("\n")
                .toString();
    }
}
