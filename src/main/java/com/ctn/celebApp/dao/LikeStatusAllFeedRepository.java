package com.ctn.celebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ctn.celebApp.entity.NewsFeedLikeDetails;

public interface LikeStatusAllFeedRepository extends JpaRepository<NewsFeedLikeDetails, String> {

	List<NewsFeedLikeDetails> findByNewsFeedId(Integer newsFeedId);

	List<NewsFeedLikeDetails> findByUserId(Integer userId);
}
