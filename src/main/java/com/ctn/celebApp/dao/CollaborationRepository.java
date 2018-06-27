package com.ctn.celebApp.dao;

/**
 * @author Aayush
 *
 */

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.Collaboration;

public interface CollaborationRepository extends CrudRepository<Collaboration, Long> {

}
