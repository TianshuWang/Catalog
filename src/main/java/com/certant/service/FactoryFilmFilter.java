package com.certant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certant.entities.Criteria;

@Service
public class FactoryFilmFilter{		
	@Autowired
	private FilterByCategory filterByCategory;
	
	@Autowired
	private FilterByOrigin filterByOrigin;
	
	@Autowired
	private FilterByYear filterByYear;
	
	@Autowired
	private FilterByScore filterByScore;
	
	@Autowired
	private FilterByName filterByName;
	
	public FilmFilter getFilter(Criteria criteria){
		FilmFilter filter = null;
		
		if("Category".equals(criteria.getName())) {
			filter = filterByCategory; 
		}
		else if("Year".equals(criteria.getName())) {
			filter = filterByYear;
		}
		else if("Origin".equals(criteria.getName())) {
			filter = filterByOrigin;
		}		
		else if("Name".equals(criteria.getName())) {
			filter = filterByName;
		}	
		else if("Score".equals(criteria.getName())) {
			filter = filterByScore;
		}
		return filter;
	}
}
