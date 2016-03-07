package com.test.task.dao.daoImpl;

import com.test.task.dao.ClientDao;
import com.test.task.entity.Client;
import org.hibernate.criterion.Restrictions;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {
    @Override
    public Client getByEmailOrLogin(String emailOrLogin) {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq("login", emailOrLogin))
                        .add(Restrictions.eq("email", emailOrLogin)))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Client getByLogin(String login) {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("login", login))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Client getByEmail(String email) {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("email", email))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Class getEntityClass() {
        return Client.class;
    }
}
