package com.certant.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.certant.entities.Item;
import com.certant.service.ItemFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ItemFilterTest {
	@Autowired
	private ItemFilter itemFilter;
	
	
	@Test
	public void testFilterSerie() {
		List<Item> series = itemFilter.byType("Serie");
		Assert.assertEquals("Friends",series.get(0).getName());
	}
	
	@Test
	public void testFilterMusic() {
		List<Item> musics = itemFilter.byType("Music");
		Assert.assertEquals("Because I Had You",musics.get(0).getName());
	}
	
	@Test
	public void testFilterFilm() {
		List<Item> films = itemFilter.byType("Film");
		Assert.assertEquals("Joker",films.get(0).getName());
		Assert.assertEquals("Jumanji:The Next Level",films.get(1).getName());
		Assert.assertEquals("Acusada",films.get(2).getName());
	}

}
