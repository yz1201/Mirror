package cn.dbdj1201.dao.impl;

import cn.dbdj1201.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tyz1201
 * @datetime 2020-02-18 14:17
 **/
public class UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("sdadsad");
        user.setAge(25);
        userDao.addUser(user);
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void editUser() {
    }

    @Test
    public void retrieveUser() {
    }

    @Test
    public void findAll() {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.findAll());
    }

    @Test
    public void login() {
        User user = new User();
        user.setUsername("test1");
        user.setPassword("test1");
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.login(user));

    }
}