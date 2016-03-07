package com.test.task.dao;

import com.test.task.entity.Client;
import com.test.task.exception.DaoException;

public interface ClientDao extends GenericDao {
    Client getByEmailOrLogin(String emailOrLogin) throws DaoException;

    Client getByLogin(String login) throws DaoException;

    Client getByEmail(String email) throws DaoException;
}
