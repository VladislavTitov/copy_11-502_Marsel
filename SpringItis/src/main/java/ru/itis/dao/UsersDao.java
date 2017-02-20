package ru.itis.dao;

import ru.itis.model.User;

import java.util.List;

public interface UsersDao extends BaseDao<User> {
    List<User> findByAge(int age);
}
