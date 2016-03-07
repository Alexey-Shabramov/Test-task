package com.test.task.service.serviceImpl;

import com.test.task.dao.daoImpl.ClientDaoImpl;
import com.test.task.entity.Client;
import com.test.task.exception.DaoException;
import com.test.task.exception.ServiceException;
import com.test.task.service.ClientService;
import com.test.task.util.PasswordUtil;
import org.springframework.transaction.annotation.Transactional;

public class ClientServiceImpl extends GenericServiceImpl<Client, ClientDaoImpl> implements ClientService {
    @Override
    @Transactional
    public Client addNewClient(Client client) throws ServiceException  {
        client.setPassword(PasswordUtil.encryptPassword(client.getPassword()));
        try {
            dao.save(client);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when adding new client.");
        }
        return client;
    }

    @Override
    @Transactional
    public Client changePassword(Long clientId, String password) throws ServiceException {
        Client client = null;
        try {
            client = dao.get(clientId);
            client.setPassword(PasswordUtil.encryptPassword(password));
            dao.save(client);
        } catch (DaoException e) {
            throw new ServiceException("Error occurs when changing password to client.");
        }
        return client;
    }

    @Override
    @Transactional
    public Client getByLogin(String login) throws ServiceException  {
        try {
            return dao.getByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException("Can't get client by login.");
        }
    }

    @Override
    @Transactional
    public Client getByEmail(String email) throws ServiceException {
        try {
            return dao.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException("Can't get client by email.");
        }
    }

    @Override
    @Transactional
    public Client getByEmailOrLogin(String emailOrLogin) throws ServiceException {
        try {
            return dao.getByEmailOrLogin(emailOrLogin);
        } catch (DaoException e) {
            throw new ServiceException("Can't get client by email or login.");
        }
    }
}

