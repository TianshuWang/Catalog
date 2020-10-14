package com.certant.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("serie")
@Component
@Lazy
public class Serie extends Type{
	@Autowired(required=false)
	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Integer getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
