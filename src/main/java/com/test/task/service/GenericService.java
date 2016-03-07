package com.test.task.service;

import com.test.task.entity.Identifier;

import java.util.List;

public interface GenericService<T extends Identifier> {

    T get(long id);

    boolean isExists(long id);

    void save(T obj);

    void delete(T obj);

    List<T> listAll();
}
