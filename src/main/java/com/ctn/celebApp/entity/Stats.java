package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name="tournamentstats")
public class Stats {

	@Id
	@GeneratedValue
	
	private Integer id;
	
	private String matches;
	
	private String wickets;
	
	private String runs;
	
	private String notout;
	
	private String fivewicket;
	
	private String fourwicket;
	
	private String threewicket;
	
	private String fiftes;
	
	private String hundred;
	
	private String catches;
	
	private String runout;
	
	private String mom;
	
	private String best;
	
	private String bbf;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}

	public String getMatches() {
		return matches;
	}

	public void setMatches(String matches) {
		this.matches = matches;
	}

	public String getRuns() {
		return runs;
	}

	public void setRuns(String runs) {
		this.runs = runs;
	}

	public String getNotout() {
		return notout;
	}

	public void setNotout(String notout) {
		this.notout = notout;
	}

	public String getFivewicket() {
		return fivewicket;
	}

	public void setFivewicket(String fivewicket) {
		this.fivewicket = fivewicket;
	}

	public String getFourwicket() {
		return fourwicket;
	}

	public void setFourwicket(String fourwicket) {
		this.fourwicket = fourwicket;
	}

	public String getThreewicket() {
		return threewicket;
	}

	public void setThreewicket(String threewicket) {
		this.threewicket = threewicket;
	}

	public String getFiftes() {
		return fiftes;
	}

	public void setFiftes(String fiftes) {
		this.fiftes = fiftes;
	}

	public String getHundred() {
		return hundred;
	}

	public void setHundred(String hundred) {
		this.hundred = hundred;
	}

	public String getCatches() {
		return catches;
	}

	public void setCatches(String catches) {
		this.catches = catches;
	}

	public String getRunout() {
		return runout;
	}

	public void setRunout(String runout) {
		this.runout = runout;
	}

	public String getMom() {
		return mom;
	}

	public void setMom(String mom) {
		this.mom = mom;
	}

	public String getBest() {
		return best;
	}

	public void setBest(String best) {
		this.best = best;
	}

	public String getBbf() {
		return bbf;
	}

	public void setBbf(String bbf) {
		this.bbf = bbf;
	}
	
	
}
