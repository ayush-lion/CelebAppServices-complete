package com.ctn.celebApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ctn.celebApp.entity.Quizgame;

public interface QuizRepository extends CrudRepository<Quizgame, String> {

}
