package com.test.task.service.serviceImpl;

import com.test.task.dao.daoImpl.ClientDaoImpl;
import com.test.task.entity.Client;
import com.test.task.service.ClientService;
import com.test.task.util.PasswordUtil;
import org.springframework.transaction.annotation.Transactional;

public class ClientServiceImpl extends GenericServiceImpl<Client, ClientDaoImpl> implements ClientService {
    @Override
    @Transactional
    public Client addNewClient(Client client) {
        client.setPassword(PasswordUtil.encryptPassword(client.getPassword()));
        dao.save(client);
        return client;
    }

    @Override
    @Transactional
    public Client changePassword(Long clientId, String password) {
        Client client = dao.get(clientId);
        client.setPassword(PasswordUtil.encryptPassword(password));
        dao.save(client);
        return client;
    }

    @Override
    @Transactional
    public Client getByLogin(String login) {
        return dao.getByLogin(login);
    }

    @Override
    @Transactional
    public Client getByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    @Transactional
    public Client getByEmailOrLogin(String emailOrLogin) {
        return dao.getByEmailOrLogin(emailOrLogin);
    }
}

