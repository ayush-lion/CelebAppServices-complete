package com.ctn.celebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctn.celebApp.entity.NewsFeed;

public interface NewsFeedRepo extends JpaRepository<NewsFeed,String> {

}
