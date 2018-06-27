package com.ctn.celebApp.entity;

import org.springframework.stereotype.Component;


@Component
public class MyProfile {
	
	private Integer celebid;
	
	private String celebname;
	
	
	private Float height;
	
	private String profile;
	
	private String occupation;
	
	
	private Integer age;
	
	private Integer wicket;
	
	private Integer run;
	
	
	private String battingstyle;
	
	private String bowlingstyle;
	
	private String majorteams;
	
	private Integer matchplayed;

	public Integer getCelebid() {
		return celebid;
	}

	public void setCelebid(Integer celebid) {
		this.celebid = celebid;
	}

	public String getCelebname() {
		return celebname;
	}

	public void setCelebname(String celebname) {
		this.celebname = celebname;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWicket() {
		return wicket;
	}

	public void setWicket(Integer wicket) {
		this.wicket = wicket;
	}

	public Integer getRun() {
		return run;
	}

	public void setRun(Integer run) {
		this.run = run;
	}

	public String getBattingstyle() {
		return battingstyle;
	}

	public void setBattingstyle(String battingstyle) {
		this.battingstyle = battingstyle;
	}

	public String getBowlingstyle() {
		return bowlingstyle;
	}

	public void setBowlingstyle(String bowlingstyle) {
		this.bowlingstyle = bowlingstyle;
	}

	public String getMajorteams() {
		return majorteams;
	}

	public void setMajorteams(String majorteams) {
		this.majorteams = majorteams;
	}

	public Integer getMatchplayed() {
		return matchplayed;
	}

	public void setMatchplayed(Integer matchplayed) {
		this.matchplayed = matchplayed;
	}
	
	
	
}
