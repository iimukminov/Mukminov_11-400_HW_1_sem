package ru.kpfu.itis.mukminov.service.impl;

import ru.kpfu.itis.mukminov.dao.UserDao;
import ru.kpfu.itis.mukminov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.mukminov.dto.UserDto;
import ru.kpfu.itis.mukminov.entity.User;
import ru.kpfu.itis.mukminov.service.UserService;
import ru.kpfu.itis.mukminov.util.PasswordUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream()
                .map(user -> new UserDto(user.getName(), user.getLogin()))
                .toList();
    }

    public static Integer signUp(String login, String password, String name, String lastname) {
        if (login.isEmpty() || password.isEmpty()) {
            return 2;
        }
        if (userDao.getByLogin(login) != null) {
            return 1;
        } else {
            userDao.save(new User(0, name, lastname, PasswordUtil.encrypt(password), login));
            return 0;
        }
    }

    public static Boolean checkLoginPassword(String login,String password) {
        User user = userDao.getByLogin(login);
        return user != null && user.getPassword().equals(PasswordUtil.encrypt(password));
    }
}
