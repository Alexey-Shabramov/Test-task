package com.test.task.dao.daoImpl;

import com.test.task.dao.GenericDao;
import com.test.task.entity.Identifier;
import com.test.task.exception.DaoException;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class GenericDaoImpl<T extends Identifier> extends AbstractDao implements GenericDao {

    @Override
    public T get(Long id) throws DaoException {
        return (T) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("id", id))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public boolean isExists(Long id) throws DaoException  {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public void save(Identifier entity) throws DaoException  {
        if (entity.isNew()) {
            getSession().save(entity);
        } else {
            Object merged = getSession().merge(entity);
        }
    }

    @Override
    public void delete(Identifier entity) throws DaoException  {
        getSession().delete(entity);
    }

    @Override
    public List<T> listAll() throws DaoException  {
        return (List<T>) getSession().createCriteria(getEntityClass()).list();
    }
}