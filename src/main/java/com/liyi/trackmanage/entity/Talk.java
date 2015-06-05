package com.liyi.trackmanage.entity;


import com.liyi.trackmanage.util.StringUtil;

/**
 * 
 * @author liyi
 * @date 2015年5月30日
 * @desc talk
 */
public class Talk {
	
	private String title;
	private int useTime;
	
	private static final String LIGHTING = "lightning";
	private static final int LIGHTING_TIME = 5;
	
	public Talk(String title){
		this.title = title;
		getUseTimeFromTitle(title);
	}

	public String getTitle() {
		return title;
	}
	public int getUseTime() {
		return useTime;
	}
	public void getUseTimeFromTitle(String title){
		String []x = title.split(" ");
		if(LIGHTING.equals(x[x.length - 1])){
			this.useTime = LIGHTING_TIME;
		}else{
			this.useTime = StringUtil.getNumFromString(x[x.length - 1]);
		}
	}
}
