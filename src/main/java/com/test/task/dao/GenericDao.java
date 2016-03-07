package com.test.task.dao;

import com.test.task.entity.Identifier;
import com.test.task.exception.DaoException;

import java.util.List;

public interface GenericDao<T extends Identifier> {
    T get(Long id) throws DaoException;

    boolean isExists(Long id) throws DaoException;

    void save(T obj) throws DaoException;

    void delete(T obj) throws DaoException;

    List<T> listAll() throws DaoException;

    Class getEntityClass() throws DaoException;
}
