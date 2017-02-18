package ru.itis.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.dao.impl.config.TestDaoConfig;
import ru.itis.model.User;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoConfig.class)
public class UsersDaoJdbcImplTest {

    @Autowired
    private UsersDaoJdbcImpl usersDao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByAge() throws Exception {
        User user = usersDao.findByAge(21).get(0);
        System.out.println(user.getName());
    }

}