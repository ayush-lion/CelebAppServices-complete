
package com.ctn.celebApp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctn.celebApp.entity.NewsFeedLikeDetails;

/**
 * @author Aayush
 *
 */
@Transactional
public interface NewsFeedLikeRepository extends JpaRepository<NewsFeedLikeDetails, String> {

	List<NewsFeedLikeDetails> findByNewsFeedId(Integer newsFeedId);

	NewsFeedLikeDetails findByNewsFeedLikeId(Integer newsFeedLikeId);
	
}
