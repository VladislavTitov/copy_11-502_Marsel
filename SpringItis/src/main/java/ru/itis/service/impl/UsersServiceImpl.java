package ru.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.dao.AutoDao;
import ru.itis.dao.UsersDao;
import ru.itis.model.Auto;
import ru.itis.model.User;
import ru.itis.service.UsersService;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    @Qualifier("hibernate.auto.dao")
    private AutoDao autoDao;

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Auto> getAllAuto() {
        return autoDao.findAll();
    }
}
