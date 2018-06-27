package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posturl")

public class PostUrl {
	
	@Id
	@GeneratedValue
	private Integer newsFeedId;
	
	private Integer userId;

	private String postUrl;

	public Integer getNewsFeedId() {
		return newsFeedId;
	}

	public void setNewsFeedId(Integer newsFeedId) {
		this.newsFeedId = newsFeedId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
}
