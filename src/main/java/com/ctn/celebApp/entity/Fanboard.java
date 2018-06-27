package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Aayush
 *
 */

import org.springframework.stereotype.Component;

@Component
@Entity(name="fanboard")
public class Fanboard {

	@Id
	@GeneratedValue
	
	private Integer fanid;
	
	private Integer celebid;
	
	private String fan;

	public Integer getFanid() {
		return fanid;
	}

	public void setFanid(Integer fanid) {
		this.fanid = fanid;
	}

	public Integer getCelebid() {
		return celebid;
	}

	public void setCelebid(Integer celebid) {
		this.celebid = celebid;
	}

	public String getFan() {
		return fan;
	}

	public void setFan(String fan) {
		this.fan = fan;
	}
}
