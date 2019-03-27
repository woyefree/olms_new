package com.neuedu.olms.po;

import java.util.Date;

public class Token {
	private Long userId;
	private Date loginTime;
	private String token;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "Token [userId=" + userId + ", loginTime=" + loginTime + ", token=" + token + "]";
	}
	
}
