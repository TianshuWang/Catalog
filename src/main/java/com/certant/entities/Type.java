package com.certant.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Component
@Lazy
@Entity
@Table(name="type")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Type extends EntityPersistence{
	@Autowired(required=false)
	@Expose(serialize = true, deserialize = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Integer getYear();
	
	public abstract Category getCategory();
	
	public abstract String getOrigin();
}
