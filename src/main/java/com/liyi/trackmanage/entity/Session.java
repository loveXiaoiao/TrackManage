package com.liyi.trackmanage.entity;

import java.util.List;

public class Session {

    public Session(List<Talk> talks) {
        this.talks = talks;
    }

    private List<Talk> talks;

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

}
