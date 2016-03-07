package com.test.task.service.serviceImpl;

import com.test.task.dao.GenericDao;
import com.test.task.entity.Identifier;
import com.test.task.exception.DaoException;
import com.test.task.exception.ServiceException;
import com.test.task.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<T extends Identifier, D extends GenericDao> implements GenericService<T> {

    protected D dao;

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public T get(long id) throws ServiceException {
        try {
            return (T) dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when getting entity by id.");
        }
    }

    @Override
    @Transactional
    public boolean isExists(long id) throws ServiceException  {
        try {
            return dao.isExists(id);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when checking entity is exists.");
        }
    }

    @Override
    @Transactional
    public void save(T obj) throws ServiceException  {
        try {
            dao.save(obj);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when saving entity.");
        }
    }

    @Override
    @Transactional
    public void delete(T obj) throws ServiceException  {
        try {
            dao.delete(obj);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when entity.");
        }
    }

    @Override
    @Transactional
    public List<T> listAll() throws ServiceException  {
        try {
            return dao.listAll();
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when getting all entity list by id.");
        }
    }
}

