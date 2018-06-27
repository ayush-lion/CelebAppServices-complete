package com.ctn.celebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctn.celebApp.entity.UserCommentDetails;

public interface UserCommentRepository extends JpaRepository<UserCommentDetails, Integer>{

	List<UserCommentDetails> findByNewsFeedId(Integer newsFeedId);
	
}
