package com.certant.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Entity
@DiscriminatorValue("film")
@Component
@Lazy
public class Film extends Type{
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	@Expose(serialize = true, deserialize = true)
	private Category category;
	
	@Autowired(required=false)
	@Column(name = "year")
	@Expose(serialize = true, deserialize = true)
	private Integer year;
	
	@Autowired(required=false)
	@Column(name = "origin")
	@Expose(serialize = true, deserialize = true)
	private String origin;
			
	public Category getCategory() {
		return this.category;
	}
		
	public void setCategory(Category Category) {
		this.category = Category;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getYear() {
		return this.year;
	}

	public String getOrigin() {
		return this.origin;
	}
	
}
