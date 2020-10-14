package com.certant.persistence;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

public class FactoryDAOImp {
    private static HashMap<String,DAOImp> repos;

    static {
        repos = new HashMap<>();
    }

    public static <T> DAOImp<T> get(Class<T> type){
        DAOImp<T> repo;
        if(repos.containsKey(type.getName())){
            repo = repos.get(type.getName());
        }
        else{
            repo = new DAOImp<>(new DAOHibernate<>(type));
            repos.put(type.toString(), repo);
        }
        return repo;
    }
}