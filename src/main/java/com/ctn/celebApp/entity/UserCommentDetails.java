package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newsfeedcomment")

public class UserCommentDetails {

	@Id
	@GeneratedValue
	
	private Integer newsFeedCommentId;
	
	private Integer newsFeedId;
	
	private Integer userId;
	
	private String comment;
	
	public Integer getNewsFeedCommentId() {
		return newsFeedCommentId;
	}


	public void setNewsFeedCommentId(Integer newsFeedCommentId) {
		this.newsFeedCommentId = newsFeedCommentId;
	}


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


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}	
}
