package com.ctn.celebApp.entity;

/**
 * @author Aayush
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="user")

public class User {
	@Id
	@GeneratedValue

	private Integer userId;

	private String userName;

	private String email;

	private String password;
	
	private Boolean socialMedia;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(Boolean socialMedia) {
		this.socialMedia = socialMedia;
	}	
}
