package com.ctn.celebApp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ctn.celebApp.entity.PostVideos;

public interface PostVideoRepo extends JpaRepository<PostVideos, String> {

	List<PostVideos> findByUserId(Integer userId);

}
