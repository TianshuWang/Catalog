package com.certant.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "item")
@Component
@Lazy
public class Item extends EntityPersistence{
 	@Autowired(required=false)
	@Column(name = "name")
 	@Expose(serialize = true, deserialize = true)
	private String name;		
 	
 	@Autowired(required=false)
 	@Qualifier("film")
 	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type")
 	@Expose(serialize = true, deserialize = true)
	private Type type;
 	
	@Autowired(required=false)
	@Column(name = "score")
	@Expose(serialize = true, deserialize = true)
	private double score;
	
	@Autowired(required=false)
	@OneToMany(mappedBy="item",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@Expose(serialize = false, deserialize = false)
	private List<Comment> comments;
		
				
	public String getName() {
		return this.name;
	}
	
	public Double getScore() {
		return this.score;
	}	
	
	public List<Comment> getComments(){
		return this.comments;
	}
		
	public void setName(String name) {
		this.name = name;
	}
		
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
