package com.mysqlauthentication.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "springsecuritydb")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usename", length=50, nullable=false)
	private String userName;

	@Column(name = "password", length=800, nullable=false)
	private String password;

	@Column(name = "role", length=50)
	private String role;

	@Column(name = "full_name", length=100)
	private String fullName;

	@Column(name = "enabled")
	private int enabled;

	@Column(name = "country" , length=30)
	private String country;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
