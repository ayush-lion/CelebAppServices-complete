package com.ctn.celebApp.userresponse;

import com.ctn.celebApp.enums.Status;

public class UserQuizResponse {

	private Integer quizId;
	
	private Status status;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
}
