package com.ctn.celebApp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ctn.celebApp.entity.Employe;

@Transactional
public interface EmployeRepository extends JpaRepository<Employe, Long> {

	@Query(value="SELECT * FROM employe WHERE empname=:empname ORDER BY chekin DESC LIMIT 1", nativeQuery = true)
	Employe getLastData(@Param("empname") String empname);
}
