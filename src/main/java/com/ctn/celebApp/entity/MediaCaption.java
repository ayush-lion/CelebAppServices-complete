package com.ctn.celebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mediacaption")

public class MediaCaption {
	
	@Id
	@GeneratedValue

	@Column(name="mediacaptionid")
	private Integer id;
	
	@Column(name="mediaurl")
	private String mediaurl;
	
	@Column(name="caption")
	private String caption;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMediaurl() {
		return mediaurl;
	}

	public void setMediaurl(String mediaurl) {
		this.mediaurl = mediaurl;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
