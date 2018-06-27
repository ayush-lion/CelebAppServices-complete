package com.ctn.celebApp.userresponse;

import com.ctn.celebApp.enums.Status;

public class UserCommentResponse {
	
	private Integer userId;
	
	private String userName;
	
	private Integer newsFeedId;
	
	private String profilePic;
	
	private String comment;

	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getNewsFeedId() {
		return newsFeedId;
	}
	public void setNewsFeedId(Integer newsFeedId) {
		this.newsFeedId = newsFeedId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}