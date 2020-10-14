package com.certant.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class DAOImp<T> {

    private DAO<T> dao;
    
    public DAOImp(DAO<T> dao) {
    	this.dao = dao;
    }

    public void setDao(DAO<T> dao) {
        this.dao = dao;
    }

    public void add(Object unObjeto){
        this.dao.add(unObjeto);
    }

    public void update(Object unObjeto){
        this.dao.update(unObjeto);
    }

    public void delete(Object unObjeto){
        this.dao.delete(unObjeto);
    }

    public List<T> findAll(){
        return this.dao.findAll();
    }

    public T find(int id){
        return this.dao.findById(id);
    }
}
