package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="tournament")
public class Tournament {

	@Id
	@GeneratedValue
	
	private Integer id;
	
	private String url;
	
	private String tournamenttype;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTournamenttype() {
		return tournamenttype;
	}

	public void setTournamenttype(String tournamenttype) {
		this.tournamenttype = tournamenttype;
	}
}
