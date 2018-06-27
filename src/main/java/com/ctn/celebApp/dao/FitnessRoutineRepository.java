package com.ctn.celebApp.dao;

/**
 * @author Aayush
 *
 */

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.FitnessRoutine;

public interface FitnessRoutineRepository extends CrudRepository<FitnessRoutine, Long> {

}
