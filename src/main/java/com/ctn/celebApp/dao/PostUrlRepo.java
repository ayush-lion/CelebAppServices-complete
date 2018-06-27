package com.ctn.celebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctn.celebApp.entity.PostUrl;

public interface PostUrlRepo extends JpaRepository<PostUrl, String>{

	List<PostUrl> findByUserId(Integer userId);

}
