package com.tms.tmsapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TM_USERMASTER")
public class UserEO {
	
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ROLENAME")
	private String rolename;
	
	public UserEO() {
		
	}

	public UserEO(String username, String password, String rolename) {
		this.username = username;
		this.password = password;
		this.rolename = rolename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "UserEO [username=" + username + ", password=" + password + ", rolename=" + rolename + "]";
	}
}
