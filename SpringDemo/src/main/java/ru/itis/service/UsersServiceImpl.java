package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.dao.UsersDao;

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public String getNameOfUser(int userId) {
        return usersDao.getUser(userId).getName();
    }

}
