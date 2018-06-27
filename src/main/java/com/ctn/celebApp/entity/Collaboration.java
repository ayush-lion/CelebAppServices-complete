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
@Entity(name="collaboration")
public class Collaboration {

	@Id
	@GeneratedValue
	
	private Integer collaborationid;
	
	private Integer celebid;
	
	private String name;
	
	public Integer getCollaborationid() {
		return collaborationid;
	}

	public void setCollaborationid(Integer collaborationid) {
		this.collaborationid = collaborationid;
	}

	public Integer getCelebid() {
		return celebid;
	}

	public void setCelebid(Integer celebid) {
		this.celebid = celebid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
