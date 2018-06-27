package com.ctn.celebApp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="employe")
public class Employe {
	
	@Id
	@GeneratedValue
	
	private int id;
	
	private String empname;
	
	private String chekin;
	
	private String chekout;
	
	private String dayformatted;
	
	private String duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getChekin() {
		return chekin;
	}

	public void setChekin(String chekin) {
		this.chekin = chekin;
	}

	public String getChekout() {
		return chekout;
	}

	public void setChekout(String chekout) {
		this.chekout = chekout;
	}

	public String getDayformatted() {
		return dayformatted;
	}

	public void setDayformatted(String dayformatted) {
		this.dayformatted = dayformatted;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
