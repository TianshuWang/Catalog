package com.certant.service;

import java.util.List;

import com.certant.entities.Criteria;
import com.certant.entities.Item;

public interface FilmFilter {
	public List<Item> filter(Criteria criteria);
}
