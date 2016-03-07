package com.test.task.dao.daoImpl;

import com.test.task.dao.ClientDao;
import com.test.task.entity.Client;
import com.test.task.exception.DaoException;
import org.hibernate.criterion.Restrictions;

public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDao {
    @Override
    public Client getByEmailOrLogin(String emailOrLogin) throws DaoException {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq("login", emailOrLogin))
                        .add(Restrictions.eq("email", emailOrLogin)))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Client getByLogin(String login) throws DaoException  {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("login", login))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Client getByEmail(String email) throws DaoException  {
        return (Client) getSession().createCriteria(getEntityClass())
                .add(Restrictions.eq("email", email))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Class getEntityClass() throws DaoException {
        return Client.class;
    }
}
