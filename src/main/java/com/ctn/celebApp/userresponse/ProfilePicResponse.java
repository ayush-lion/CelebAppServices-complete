package com.ctn.celebApp.userresponse;

import com.ctn.celebApp.enums.Status;

public class ProfilePicResponse {

private Integer profilepicId;
	
	private String profilePic;

	private Status status;
	
	private String message;

	public Integer getProfilePicId() {
		return profilepicId;
	}

	public void setProfilePicId(Integer profilepicId) {
		this.profilepicId = profilepicId;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

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
