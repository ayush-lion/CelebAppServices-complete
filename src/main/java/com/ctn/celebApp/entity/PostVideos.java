package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postvideo")

public class PostVideos {
	
	@Id
	@GeneratedValue
	
	private Integer postvideoId;
	
	private Integer userId;
	
	private String videoUrl;

	public Integer getPostvideoId() {
		return postvideoId;
	}

	public void setPostvideoId(Integer postvideoId) {
		this.postvideoId = postvideoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}	
}
