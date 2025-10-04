package ru.kpfu.itis.mukminov.service;

import ru.kpfu.itis.mukminov.dto.UserDto;
import ru.kpfu.itis.mukminov.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
}
