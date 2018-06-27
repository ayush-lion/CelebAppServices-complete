package com.ctn.celebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newsfeedlike")

public class NewsFeedLikeDetails {

		@Id
		@GeneratedValue
		@Column(name = "newsFeedLikeId")
		private Integer newsFeedLikeId;
	   
		@Column(name = "newsFeedId")
		private Integer newsFeedId;
		
		@Column(name = "userId")
		private Integer userId;
		
		@Column(name = "likeType")
		private String likeType;
		
		@Column(name = "likeCount")
		private Integer likeCount;
		
		public Integer getNewsFeedLikeId() {
			return newsFeedLikeId;
		}

		public void setNewsFeedLikeId(Integer newsFeedLikeId) {
			this.newsFeedLikeId = newsFeedLikeId;
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

		public String getLikeType() {
			return likeType;
		}

		public void setLikeType(String likeType) {
			this.likeType = likeType;
		}

		public Integer getLikeCount() {
			return likeCount;
		}

		public void setLikeCount(Integer likeCount) {
			this.likeCount = likeCount;
		}
}