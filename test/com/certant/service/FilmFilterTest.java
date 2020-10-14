package com.certant.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.certant.entities.Criteria;
import com.certant.entities.Item;
import com.certant.error.SearchException;
import com.certant.service.FactoryFilmFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FilmFilterTest {
	@Autowired
	private FactoryFilmFilter factoryFilmFilter;
	
	@Autowired
	private Criteria criteria;
	
	@Test
	public void testFilmFilterByCategoryAction() {
		criteria.setName("Category");
		criteria.setContent("Action");
		
		List<Item> films = factoryFilmFilter.getFilter(criteria).filter(criteria); 
		Assert.assertEquals("Jumanji:The Next Level",films.get(0).getName());
	}
	
	@Test
	public void testFilmFilterByYear2018() {
		criteria.setName("Year");
		criteria.setContent("2018");
		
		List<Item> films = factoryFilmFilter.getFilter(criteria).filter(criteria); 
		Assert.assertEquals("Acusada",films.get(0).getName());
	}
	
	
	@Test
	public void testFilmFilterByOriginArgentina() {
		criteria.setName("Origin");
		criteria.setContent("Argentina");
		
		List<Item> films = factoryFilmFilter.getFilter(criteria).filter(criteria); 
		Assert.assertEquals("Acusada",films.get(0).getName());
	}
	
	@Test
	public void testFilmFilterByScore3() {
		criteria.setName("Score");
		criteria.setContent("3");
		
		List<Item> films = factoryFilmFilter.getFilter(criteria).filter(criteria); 
		Assert.assertEquals("Joker",films.get(0).getName());
	}
	
	@Test
	public void testFilmFilterByNameJoker() {
		criteria.setName("Name");
		criteria.setContent("Joker");
		
		List<Item> films = factoryFilmFilter.getFilter(criteria).filter(criteria); 
		Assert.assertEquals("Joker",films.get(0).getName());
	}
}
