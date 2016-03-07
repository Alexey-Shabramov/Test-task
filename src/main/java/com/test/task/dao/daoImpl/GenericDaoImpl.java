package com.test.task.dao.daoImpl;

import com.test.task.dao.GenericDao;
import com.test.task.entity.Identifier;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class GenericDaoImpl<T extends Identifier> extends AbstractDao implements GenericDao {

    @Override
    public T get(Long id) {
        return (T) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("id", id))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public boolean isExists(Long id) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void save(Identifier entity) {
        if (entity.isNew()) {
            getSession().save(entity);
        } else {
            Object merged = getSession().merge(entity);
        }
    }

    @Override
    public void delete(Identifier entity) {
        getSession().delete(entity);
    }

    @Override
    public List<T> listAll() {
        return (List<T>) getSession().createCriteria(getEntityClass()).list();
    }
}