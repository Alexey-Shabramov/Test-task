package com.test.task.service;

import com.test.task.entity.Client;

public interface ClientService extends GenericService<Client> {
    Client getByEmailOrLogin(String emailOrLogin);

    Client getByLogin(String login);

    Client getByEmail(String email);

    Client addNewClient(Client client);

    Client changePassword(Long clientId, String password);
}
