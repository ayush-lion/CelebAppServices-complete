package com.ctn.celebApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.CelebDetails;

public interface CelebRepository extends CrudRepository<CelebDetails, Long> {

	CelebDetails findByEmail(String email);

}
