package com.test.task.service.serviceImpl;

import com.test.task.dao.GenericDao;
import com.test.task.entity.Identifier;
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
    public T get(long id) {
        return (T) dao.get(id);
    }

    @Override
    @Transactional
    public boolean isExists(long id) {
        return dao.isExists(id);
    }

    @Override
    @Transactional
    public void save(T obj) {
        dao.save(obj);
    }

    @Override
    @Transactional
    public void delete(T obj) {
        dao.delete(obj);
    }

    @Override
    @Transactional
    public List<T> listAll() {
        return dao.listAll();
    }
}

