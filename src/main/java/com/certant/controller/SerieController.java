package com.certant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.certant.entities.Category;
import com.certant.entities.Comment;
import com.certant.entities.Item;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;
import com.certant.service.CommentService;
import com.certant.service.ItemFilter;

@Controller
@RequestMapping("series")
public class SerieController {
	@Autowired
	private ItemFilter itemFilter;
	
	@Autowired
	private CommentService commentService;
	
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	@RequestMapping("")
	public ModelAndView getSeries() {
		ModelAndView mView = new ModelAndView("series");
		
		List<Item> series = itemFilter.byType("Serie");
		
		mView.addObject("series",series);
		return mView; 
	}
	
	@RequestMapping("serie")
	public ModelAndView getserie(int id) {
		ModelAndView mView = new ModelAndView("serie");
		
		Item item = repoItem.find(id);
		
		mView.addObject("serie",item);
		return mView; 
	}
	
	@RequestMapping("/serie/comment")
	public ModelAndView addScoreCommentSerie(int id,Comment comment) {
		ModelAndView mView = new ModelAndView("comment");
		
		Item item = repoItem.find(id);
		commentService.addCommentToItem(item,comment);
		repoItem.update(item);
		
		mView.addObject("item",item);
		return mView; 
	}	
}
