package com.ctn.celebApp.userrequest;

import java.util.List;

public class VideoUrlRequest {
	
	private Integer userId;
	
	private List<String> video;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getVideo() {
		return video;
	}

	public void setVideo(List<String> video) {
		this.video = video;
	}
}
