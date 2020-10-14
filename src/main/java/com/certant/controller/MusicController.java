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
@RequestMapping("musics")
public class MusicController {		
	@Autowired
	private ItemFilter itemFilter;
	
	@Autowired
	private CommentService commentService;
	
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	@RequestMapping("")
	public ModelAndView getMusics() {
		ModelAndView mView = new ModelAndView("musics");
		
		List<Item> series = itemFilter.byType("Music");
		
		mView.addObject("musics",series);
		return mView; 
	}
	
	@RequestMapping("music")
	public ModelAndView getMusic(int id) {
		ModelAndView mView = new ModelAndView("music");
		
		Item item = repoItem.find(id);
		
		mView.addObject("music",item);
		return mView; 
	}
	
	@RequestMapping("/music/comment")
	public ModelAndView addScoreCommentMusic(int id,Comment comment) {
		ModelAndView mView = new ModelAndView("comment");
		
		Item item = repoItem.find(id);
		commentService.addCommentToItem(item,comment);
		repoItem.update(item);
		
		mView.addObject("item",item);
		return mView; 
	}	
}
