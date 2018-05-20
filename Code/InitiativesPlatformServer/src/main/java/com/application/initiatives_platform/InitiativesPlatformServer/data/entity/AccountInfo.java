package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountInfo {

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "user_type")
	private String userType;

	public AccountInfo() {
		super();
	}

	public AccountInfo(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
