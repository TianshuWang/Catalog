package com.certant.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DAOHibernate<T> implements DAO<T> {
    private Class<T> type;
    
    public DAOHibernate(Class<T> type) {
		this.type = type;
	}

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> critera = builder.createQuery(this.type);
        critera.from(type);
        List<T> entities = EntityManagerHelper.getEntityManager().createQuery(critera).getResultList();
        return entities;
    }

    @Override
    public T findById(int id) {
        return EntityManagerHelper.getEntityManager().find(type, id);
    }
   

    @Override
    public void add(Object object) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }
}
