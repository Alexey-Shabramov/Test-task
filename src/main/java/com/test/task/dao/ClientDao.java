package com.test.task.dao;

import com.test.task.entity.Client;

public interface ClientDao extends GenericDao {
    Client getByEmailOrLogin(String emailOrLogin);

    Client getByLogin(String login);

    Client getByEmail(String email);
}
