package com.ctn.celebApp.dao;

/**
 * @author Aayush
 *
 */

import org.springframework.data.repository.CrudRepository;
import com.ctn.celebApp.entity.Fanboard;

public interface FanBoardRepository extends CrudRepository<Fanboard, Long>{
	
	Fanboard findByCelebid(Integer celebid);
}
