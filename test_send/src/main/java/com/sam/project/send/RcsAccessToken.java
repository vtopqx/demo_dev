package com.sam.project.send;

import java.util.Calendar;
import java.util.Date;

public class RcsAccessToken {

	private String token;

	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 过期时间
	 */
	private Date expiresTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Date expiresTime) {
		this.expiresTime = expiresTime;
	}
	
	public RcsAccessToken(){
		this.createTime = new Date();
		this.expiresTime = getTenHoursAfterTime();
	}
	
	/**
	 * 获取9小时50分之后的时间点
	 * @return
	 */
	private Date getTenHoursAfterTime(){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR, 9);
		now.add(Calendar.MINUTE, 50);
		return now.getTime();
	}

}
