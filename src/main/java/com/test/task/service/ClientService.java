package com.test.task.service;

import com.test.task.entity.Client;
import com.test.task.exception.ServiceException;

public interface ClientService extends GenericService<Client> {
    Client getByEmailOrLogin(String emailOrLogin) throws ServiceException;

    Client getByLogin(String login) throws ServiceException;

    Client getByEmail(String email) throws ServiceException;

    Client addNewClient(Client client) throws ServiceException;

    Client changePassword(Long clientId, String password) throws ServiceException;
}
