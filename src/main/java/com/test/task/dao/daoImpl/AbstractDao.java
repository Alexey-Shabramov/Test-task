package com.test.task.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao {

    private SessionFactory sessionFactory;

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
