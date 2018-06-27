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
@Entity(name="mydiet")
public class MyDiet {

	@Id
	@GeneratedValue
	
	private Integer id;
	
	private String dieturl;
	
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDieturl() {
		return dieturl;
	}

	public void setDieturl(String dieturl) {
		this.dieturl = dieturl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
