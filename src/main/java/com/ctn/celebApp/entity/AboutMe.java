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
@Entity(name="celebdetails")
public class AboutMe {

	@Id
	@GeneratedValue

	private Integer celebid;

	private String celebname;

	private float height;

	private String profile;

	private String occupation;

	public int getCelebid() {
		return celebid;
	}

	public void setCelebid(int celebid) {
		this.celebid = celebid;
	}

	public String getCelebname() {
		return celebname;
	}

	public void setCelebname(String celebname) {
		this.celebname = celebname;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
