package com.certant.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface DAO<T> {
    List<T> findAll();
    T findById(int id);
    void add(Object unObjeto);
    void update(Object unObjeto);
    void delete(Object unObjeto);
}
