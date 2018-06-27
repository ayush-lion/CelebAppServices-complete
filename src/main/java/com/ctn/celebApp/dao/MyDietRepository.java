package com.ctn.celebApp.dao;

/**
 * @author Aayush
 *
 */

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.MyDiet;

public interface MyDietRepository extends CrudRepository<MyDiet, Long> {

}
