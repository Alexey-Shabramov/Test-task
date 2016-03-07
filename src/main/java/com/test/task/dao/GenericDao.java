package com.test.task.dao;

import com.test.task.entity.Identifier;

import java.util.List;

public interface GenericDao<T extends Identifier> {
    T get(Long id);

    boolean isExists(Long id);

    void save(T obj);

    void delete(T obj);

    List<T> listAll();

    Class getEntityClass();
}
