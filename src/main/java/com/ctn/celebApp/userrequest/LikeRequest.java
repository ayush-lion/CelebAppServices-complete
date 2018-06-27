package com.ctn.celebApp.userrequest;

public class LikeRequest {
	
	private Integer newsFeedId;
	   
	private Integer userId;
	   
	private String likeType;

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

	public String getLikeType() {
		return likeType;
	}

	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}	
}
