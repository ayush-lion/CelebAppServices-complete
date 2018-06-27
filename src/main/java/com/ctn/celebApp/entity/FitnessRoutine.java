package com.ctn.celebApp.entity;

/**
 * @author Aayush
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity(name="fitnessroutine")
public class FitnessRoutine {

	@Id
	@GeneratedValue
	
	private Integer celebid;
	
	private String exercise;
	
	private String sets;
	
	private String reps;
	
	private String note;

	public String getSets() {
		return sets;
	}
	public void setSets(String sets) {
		this.sets = sets;
	}
	public String getReps() {
		return reps;
	}
	public void setReps(String reps) {
		this.reps = reps;
	}
	public Integer getCelebid() {
		return celebid;
	}
	public void setCelebid(Integer celebid) {
		this.celebid = celebid;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
