package ru.kpfu.itis.mukminov.dao;

import ru.kpfu.itis.mukminov.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user);

    User getById(Integer id);

    User getByLogin(String login);
}
