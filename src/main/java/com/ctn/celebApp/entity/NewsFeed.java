package com.ctn.celebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newsfeed")

public class NewsFeed {
	
	@Id
	@GeneratedValue
	
	@Column(name="newsFeedId")
	private Integer newsFeedId;
	
	@Column(name="newsFeedUrl")
	private String newsFeedUrl;

	public Integer getNewsFeedId() {
		return newsFeedId;
	}

	public void setNewsFeedId(Integer newsFeedId) {
		this.newsFeedId = newsFeedId;
	}

	public String getNewsFeedUrl() {
		return newsFeedUrl;
	}

	public void setNewsFeedUrl(String newsFeedUrl) {
		this.newsFeedUrl = newsFeedUrl;
	}
}
