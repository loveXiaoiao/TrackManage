package com.liyi.trackmanage.entity;
/**
 * 
 * @author liyi
 * @date 2015年5月30日
 * @desc 
 */
public class Track {
	
	private Session morningSession;
	private Session afternoonSession;
	private String name;
	
	public Track(String name){
		this.name = name;
	}
	
	public Session getMorningSession() {
		return morningSession;
	}
	public void setMorningSession(Session morningSession) {
		this.morningSession = morningSession;
	}
	public Session getAfternoonSession() {
		return afternoonSession;
	}
	public void setAfternoonSession(Session afternoonSession) {
		this.afternoonSession = afternoonSession;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
