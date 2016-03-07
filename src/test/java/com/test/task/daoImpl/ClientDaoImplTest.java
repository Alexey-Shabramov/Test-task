package com.test.task.daoImpl;

import com.test.task.dao.daoImpl.ClientDaoImpl;
import com.test.task.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional
public class ClientDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session currentSession;
    @Autowired
    private ClientDaoImpl clientDao;
    private Client client;

    @Before
    public void openSession() {
        currentSession = sessionFactory.getCurrentSession();
        clientDao.setSessionFactory(sessionFactory);
        client = new Client();
        client.setLogin("riqo111");
        client.setEmail("myemail@gmail.com");
        client.setName("james");
        client.setPassword("oqwdoqwdq");
    }

    @Test
    public void testGet(){
        clientDao.save(client);
        assertNotNull(clientDao.get(client.getId()));
    }

    @Test
    public void testSave(){
        clientDao.save(client);
        assertNotNull(clientDao.get(client.getId()));
        clientDao.delete(client);
        client = new Client();
        clientDao.save(client);
        assertNotNull(clientDao.get(client.getId()));
    }

    @Test
    public void testDelete(){
        clientDao.save(client);
        clientDao.delete(client);
        assertNull(clientDao.getByEmail(client.getEmail()));
    }

    @Test
    public void testListAll(){
        for(int i=0;i<=5;i++){
            client = new Client();
            client.setLogin("riqo111");
            client.setEmail("myemail@gmail.com");
            client.setName("james");
            client.setPassword("oqwdoqwdq");
            clientDao.save(client);
        }
        assertFalse(clientDao.listAll().isEmpty());
        assertNotNull(clientDao.listAll().get(2));
    }

    @Test
    public void testGetByEmailOrLogin(){
        clientDao.save(client);
        assertNotNull(clientDao.getByEmailOrLogin(client.getEmail()));
        assertNotNull(clientDao.getByEmailOrLogin(client.getLogin()));
        assertEquals(client, clientDao.getByEmailOrLogin(client.getLogin()));
        assertEquals(client, clientDao.getByEmailOrLogin(client.getEmail()));
    }

    @Test
    public void testGetByEmail(){
        clientDao.save(client);
        assertNotNull(clientDao.getByEmail(client.getEmail()));
        assertEquals(client,clientDao.getByEmail(client.getEmail()));
    }

    @Test
    public void testGetByLogin(){
        clientDao.save(client);
        assertNotNull(clientDao.getByEmail(client.getEmail()));
        assertEquals(client,clientDao.getByEmail(client.getEmail()));
    }

    @After
    public void destroy() {
        clientDao = null;
        client = null;
    }
}
