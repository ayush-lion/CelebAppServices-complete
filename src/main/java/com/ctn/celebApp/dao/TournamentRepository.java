package com.ctn.celebApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctn.celebApp.entity.Tournament;

public abstract interface TournamentRepository extends JpaRepository<Tournament, Long> {

	@Query("FROM tournament WHERE tournamenttype='international'")
	List<Tournament> findInternationalUrl();

	@Query("FROM tournament WHERE tournamenttype='domestic'")
	List<Tournament> findDomesticUrl();

}
