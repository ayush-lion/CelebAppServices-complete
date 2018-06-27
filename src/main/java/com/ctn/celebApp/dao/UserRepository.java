package com.ctn.celebApp.dao;

/**
 * @author Aayush
 *
 */

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);

	User findByUserId(Integer userId);

}
