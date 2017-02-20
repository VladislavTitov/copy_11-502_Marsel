package ru.itis.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.dao.impl.config.TestDaoConfig;
import ru.itis.dao.impl.jdbc.AutoDaoJdbcImpl;
import ru.itis.model.Auto;

import java.util.List;

/**
 * 20.02.2017
 * AutoDaoJdbcImplTest
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDaoConfig.class)
public class AutoDaoJdbcImplTest {

    @Autowired
    private AutoDaoJdbcImpl autoDao;

    @Test
    public void findAllByUserId() throws Exception {
        List<Auto> autoList = autoDao.findAllByUserId(3L);
        int i = 0;
    }

}