package com.certant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.certant.entities.Comment;
import com.certant.entities.Criteria;
import com.certant.entities.Category;
import com.certant.entities.Item;
import com.certant.entities.Type;
import com.certant.error.SearchException;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;
import com.certant.service.CommentService;
import com.certant.service.FactoryFilmFilter;
import com.certant.service.ItemFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
@RequestMapping("films")
public class FilmController {
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	private DAOImp<Category> repoCategory = FactoryDAOImp.get(Category.class);
	
	@Autowired
	private ItemFilter itemFilter;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private FactoryFilmFilter factoryFilmFilter;

	@RequestMapping("")
	public ModelAndView getFilms() {
		ModelAndView mView = new ModelAndView("films");
		
		List<Item> films = itemFilter.byType("Film");
		
		List<Category> filmCategories = repoCategory.findAll().stream().distinct().collect(Collectors.toList());;
		List<Type> Types = films.stream().map(Item::getType).collect(Collectors.toList());
		List<String> filmOrigins = Types.stream().map(Type::getOrigin).distinct().collect(Collectors.toList());
		
		mView.addObject("films",films);
		mView.addObject("filmCategories",filmCategories);
		mView.addObject("filmOrigins",filmOrigins);
		return mView; 
	}
	
	@RequestMapping("/film")
	public ModelAndView getFilm(int id) {
		ModelAndView mView = new ModelAndView("film");
		
		Item item = repoItem.find(id);
		
		mView.addObject("film",item);
		return mView; 
	}
	
	@RequestMapping("/film/comment")
	public ModelAndView addScoreCommentToFilm(int id,Comment comment) {
		ModelAndView mView = new ModelAndView("comment");
		Item film = repoItem.find(id);
		commentService.addCommentToItem(film,comment);
		
		Item filmUpdated = repoItem.find(id);
		
		mView.addObject("film",filmUpdated);
		return mView;
	}
		
	@RequestMapping("/search")
	public ModelAndView getFilmsBy(Criteria criteria) throws SearchException {
		ModelAndView mView = new ModelAndView("search");
		List<Item> films = new ArrayList<Item>();
		
		if("All".equals(criteria.getName())) {
			films = itemFilter.byType("Film");
		}
		else {
			films = factoryFilmFilter.getFilter(criteria).filter(criteria);
		}		

		if(films.size() == 0) {
			throw new SearchException();
		}

		mView.addObject("films",films);
		mView.addObject("criteria",criteria);
		return mView; 
	}
	
	@GetMapping("/testFilms")
	@ResponseBody
	public String getTestFilms() {
		List<Item> films = itemFilter.byType("Film");
		
		Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Map<String,Object> data = new HashMap<>();
        data.put("Films",films);

        String json = gson.toJson(data);
        
        return json;
	}
	
}
