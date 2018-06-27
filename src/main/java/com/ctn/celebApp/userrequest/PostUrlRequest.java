package com.ctn.celebApp.userrequest;

import java.util.List;

public class PostUrlRequest {
	
	private Integer userId;
	
	private List<String> postUrl;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(List<String> postUrl) {
		this.postUrl = postUrl;
	}
}
