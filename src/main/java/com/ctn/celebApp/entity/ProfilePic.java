package com.ctn.celebApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "profilepicdetails")

public class ProfilePic {

		@Id
		@GeneratedValue
		
		private Integer profilePicId;
	   
		private Integer userId;
		
		private String profilePic;
		
		private String status;

		public Integer getProfilePicId() {
			return profilePicId;
		}

		public void setProfilePicId(Integer profilePicId) {
			this.profilePicId = profilePicId;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getProfilePic() {
			return profilePic;
		}

		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}	
	}