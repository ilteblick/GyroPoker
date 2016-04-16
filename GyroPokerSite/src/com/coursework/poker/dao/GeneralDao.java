package com.coursework.poker.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class GeneralDao<T extends Serializable> {

    public GeneralDao(Class<T> type) {
        this.type = type;
    }

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> type;

    public Session getCurrentSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Transactional
    public void save(T object) {
        getCurrentSession().save(object);
    }

    @Transactional
    public T saveOrUpdate(T object) {
        getCurrentSession().saveOrUpdate(object);
        return object;
    }

    @Transactional
    public void update(T object) {
        getCurrentSession().merge(object);
    }

    @Transactional
    public void delete(T object) {
        getCurrentSession().delete(object);
    }

    @Transactional
    public void deleteById(int id) {
        getCurrentSession().delete(getById(id));
    }

    public List<T> getAll() {
        try {
            return getCurrentSession().createCriteria(type).list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public T getById(int id) {
        return (T) getCurrentSession().get(type, id);
    }

}
