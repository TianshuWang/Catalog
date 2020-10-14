package com.certant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certant.entities.Criteria;
import com.certant.entities.Item;

@Service
public class FilterByScore implements FilmFilter{
	@Autowired
	private ItemFilter itemFilter;

	@Override
	public List<Item> filter(Criteria criteria) {
		List<Item> films = itemFilter.byType("Film");	
		return films.stream().filter(film->validate(film, criteria)).collect(Collectors.toList());
	}
	
	private Boolean validate(Item film,Criteria criteria) {
		return Integer.valueOf(criteria.getContent()).equals(film.getScore().intValue());
	}
}
