package ru.itis.service;

import ru.itis.model.Auto;

import java.util.List;

public interface UsersService {
    boolean isRegistered(String name);
    List<Auto> getAllAuto();
}
