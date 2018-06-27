package com.ctn.celebApp.userresponse;

public class NewsFeedResponse {
	
	private Integer newsFeedId;
	
	private String newsFeedUrl;
	
	private Integer userId;
	
	private String likeType;
	
	private Integer likeCount;
	
	private Integer disLikeCount;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getLikeType() {
		return likeType;
	}

	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getDisLikeCount() {
		return disLikeCount;
	}

	public void setDisLikeCount(Integer disLikeCount) {
		this.disLikeCount = disLikeCount;
	}
}
