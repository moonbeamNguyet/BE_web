package net.javaguides.CD_Web_backend.service;

import net.javaguides.CD_Web_backend.dto.UsersDto;
import net.javaguides.CD_Web_backend.entity.Users;

public interface UsersService {
    UsersDto createUser(UsersDto usersDto);
    UsersDto getUserByEmailAndPassWord(String email, String password);
}
