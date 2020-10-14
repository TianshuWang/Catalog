package com.certant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "comment")
@Component
@Lazy
public class Comment extends EntityPersistence{
	@Autowired(required=false)
	@Column(name = "username")

	private String username;
	
	@Autowired(required=false)
	@Column(name = "content")

	private String content;
	
	@Autowired(required=false)
	@Column(name = "score")

	private int score;
	
	@Autowired(required=false)
	@ManyToOne
	@JoinColumn(name = "item_id")

	private Item item;
		
	public String getUsername() {
		return this.username;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
