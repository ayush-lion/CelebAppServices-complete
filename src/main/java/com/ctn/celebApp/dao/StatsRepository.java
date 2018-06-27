package com.ctn.celebApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.Stats;

public interface StatsRepository extends CrudRepository<Stats,Integer> {
	
}
