package com.certant.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("music")
@Component
@Lazy
public class Music extends Type{
	@Autowired(required=false)
	@Column(name = "artist")
	private String artist;


	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public Integer getYear() {
		return null;
	}

	@Override
	public Category getCategory() {
		return null;
	}

	@Override
	public String getOrigin() {
		return null;
	}
	
}
