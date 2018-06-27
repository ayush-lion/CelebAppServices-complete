package com.ctn.celebApp.userresponse;

/**
 * @author Aayush
 *
 */

import com.ctn.celebApp.enums.Status;

public class StatusResponse {
	
	private Status status;
	
	private String message;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
