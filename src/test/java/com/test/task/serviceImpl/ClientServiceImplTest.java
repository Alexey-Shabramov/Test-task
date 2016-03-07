package com.test.task.serviceImpl;

import com.test.task.dao.daoImpl.ClientDaoImpl;
import com.test.task.entity.Client;
import com.test.task.service.serviceImpl.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional
public class ClientServiceImplTest {
    @InjectMocks
    @Autowired
    private ClientServiceImpl clientService;

    private Client client;

    @Mock
    private ClientDaoImpl clientDao;

    @Before
    public void init(){
        clientService.setDao(clientDao);
        MockitoAnnotations.initMocks(this);
        client = new Client();
        client.setLogin("riqo111");
        client.setEmail("myemail@gmail.com");
        client.setName("james");
        client.setPassword("oqwdoqwdq");
    }

    @Test
    public void testAddNewClient(){
        clientService.addNewClient(client);
        verify(clientDao).save(client);
    }

    @Test
    public void testChangePassword(){
        clientService.changePassword(client.getId(), "somePassword");
        verify(clientDao, Mockito.times(0)).save(client);
    }

    @Test
    public void testGetByLogin(){
        clientService.getByLogin("someLogin");
        verify(clientDao).getByLogin("someLogin");
    }

    @Test
    public void testGetByEmail(){
        clientService.getByEmail("someEmail");
        verify(clientDao).getByEmail("someEmail");
    }

    @Test
    public void testGetByEmailOrLogin(){
        clientService.getByEmailOrLogin("emailOrLogin");
        verify(clientDao).getByEmailOrLogin("emailOrLogin");
    }
}
