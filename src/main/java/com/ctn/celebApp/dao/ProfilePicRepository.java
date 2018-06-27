package com.ctn.celebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctn.celebApp.entity.ProfilePic;

public interface ProfilePicRepository extends JpaRepository<ProfilePic, String> {

	ProfilePic findByUserId(Integer userId);

	ProfilePic findByProfilePicId(Integer profilepicId);

}
