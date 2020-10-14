package com.certant.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.certant.entities.Comment;
import com.certant.entities.Item;

@Service
public class ScoreCalculator {
	
	public Double calculate(Item item) {
		return item.getComments().stream().mapToDouble(Comment::getScore).average().getAsDouble();
	}
}
