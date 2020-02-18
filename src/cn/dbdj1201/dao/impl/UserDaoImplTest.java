package cn.dbdj1201.dao.impl;

import cn.dbdj1201.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

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
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            user.setUsername(createNames(i));
            user.setAge(random.nextInt(150) + 1);
            user.setSex(sexGenerator(i));
            user.setAddress("河南");
            user.setEmail("test@163.com");
            user.setQq_number("541895972");
            userDao.addUser(user);
        }
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
        user.setUsername("test");
        user.setPassword("test");
        UserDaoImpl dao = new UserDaoImpl();
        System.out.println(dao.login(user));

    }

    public static String createNames(int count) {
        StringBuilder name = new StringBuilder();
        switch (count % 5) {
            case 0:
                name.append("dbdj1201").append(new Random().nextInt(65536));
            case 1:
                name.append("黄豆豆").append(new Random().nextInt(10000));
                break;
            case 2:
                name.append("张三疯").append(new Random().nextInt(10000));
                break;
            case 3:
                name.append("清琼").append(new Random().nextInt(10000));

                break;
            case 4:
                name.append("林沐").append(new Random().nextInt(10000));

                break;
            default:
                name.append("troubleMaker");
                break;
        }
        return name.toString();
    }

    public static String sexGenerator(int number) {
        if (number % 2 != 0)
            return "男";
        return "女";


    }

}