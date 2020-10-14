package com.certant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "category")
@Component
@Lazy
public class Category extends EntityPersistence{
	@Autowired(required=false)
	@Column(name = "name")	
	@Expose(serialize = true, deserialize = true)
	private String name;
	
	public String getName() {
		return this.name;
	}
}
