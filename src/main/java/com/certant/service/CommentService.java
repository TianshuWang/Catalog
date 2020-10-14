package com.certant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certant.entities.Comment;
import com.certant.entities.Item;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;

@Service
public class CommentService {
	@Autowired
	private ScoreCalculator scoreCalculator;
	
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	DAOImp<Comment> repoComment = FactoryDAOImp.get(Comment.class);
	
	public void addCommentToItem(Item item,Comment comment) {
		comment.setItem(item);
		repoComment.add(comment);
		
		item.getComments().add(comment);
		repoItem.update(item);
		
		item.setScore(scoreCalculator.calculate(item));
		repoItem.update(item);
	}
}
