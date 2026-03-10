package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {

	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "invalid_login_count")
	private int invalidLoginCount;

	@Column(name = "login_status", nullable = false, length = 50)
	private String loginStatus;

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(int loginId, String password, int invalidLoginCount, String loginStatus) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.invalidLoginCount = invalidLoginCount;
		this.loginStatus = loginStatus;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(int invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "LoginDetails [loginId=" + loginId + ", password=" + password + ", invalidLoginCount="
				+ invalidLoginCount + ", loginStatus=" + loginStatus + "]";
	}

}
