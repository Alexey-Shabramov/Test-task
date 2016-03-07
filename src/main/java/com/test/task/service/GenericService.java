package com.test.task.service;

import com.test.task.entity.Identifier;
import com.test.task.exception.ServiceException;

import java.util.List;

public interface GenericService<T extends Identifier> {

    T get(long id) throws ServiceException;

    boolean isExists(long id) throws ServiceException;

    void save(T obj) throws ServiceException;

    void delete(T obj) throws ServiceException;

    List<T> listAll() throws ServiceException;
}
