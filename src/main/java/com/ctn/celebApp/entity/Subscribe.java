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
@Entity(name = "subscribe")
public class Subscribe {

	@Id
	@GeneratedValue
	
	private Integer socialmediaid;
	
	private Integer celebid;
	
	private String socialmedia;

	public Integer getSocialmediaid() {
		return socialmediaid;
	}

	public void setSocialmediaid(Integer socialmediaid) {
		this.socialmediaid = socialmediaid;
	}

	public Integer getCelebid() {
		return celebid;
	}

	public void setCelebid(Integer celebid) {
		this.celebid = celebid;
	}

	public String getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(String socialmedia) {
		this.socialmedia = socialmedia;
	}	
}
