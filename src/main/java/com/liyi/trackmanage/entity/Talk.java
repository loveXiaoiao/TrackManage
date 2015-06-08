package com.liyi.trackmanage.entity;


import com.liyi.trackmanage.util.StringUtil;

import java.util.Date;

public class Talk {

    private String title;
    private int talkLength;
    private Date startTime;

    private static final String LIGHTING = "lightning";
    private static final int LIGHTING_TIME = 5;

    public Talk(String title) {
        this.title = title;
        this.talkLength = extractLength(title);
    }

    public String getTitle() {
        return title;
    }

    public int getTalkLength() {
        return talkLength;
    }

    private int extractLength(String title) {
        return title.endsWith(LIGHTING) ? LIGHTING_TIME : StringUtil.getNumFromString(title);
    }
}
