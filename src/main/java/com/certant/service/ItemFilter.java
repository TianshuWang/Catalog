package com.certant.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.certant.entities.Item;
import com.certant.persistence.DAOImp;
import com.certant.persistence.FactoryDAOImp;

@Service
public class ItemFilter{
	DAOImp<Item> repoItem = FactoryDAOImp.get(Item.class);
	
	public List<Item> byType(String type) {
		List<Item> items = repoItem.findAll();
		return items.stream().filter(i->type.equals(i.getType().getName())).collect(Collectors.toList());		
	}
}
