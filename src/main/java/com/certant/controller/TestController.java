package com.certant.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.certant.entities.Item;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;

@Controller
@RequestMapping("test")
public class TestController {
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	@RequestMapping("")
	public ModelAndView getTest() {
		ModelAndView mView = new ModelAndView("test");
		List<Item> items = repoItem.findAll();
		
		mView.addObject("items",items);
		
		return mView; 
	}

}
