package com.certant.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import com.certant.entities.Item;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;


public class DAOImpTest {
	private DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	@Test
	public void testFind() {
		Item joker = repoItem.find(1);
		Assert.assertEquals("Joker",joker.getName());
	}
	
	@Test
	public void testFindAll() {
		List<Item> items = repoItem.findAll();
		Assert.assertEquals("Friends",items.get(2).getName());
	}
	
}
