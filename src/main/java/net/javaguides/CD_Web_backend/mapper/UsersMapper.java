package net.javaguides.CD_Web_backend.mapper;

import net.javaguides.CD_Web_backend.dto.UsersDto;
import net.javaguides.CD_Web_backend.entity.Users;

public class UsersMapper {

    public static UsersDto mapToUsersDto(Users users){
        return new UsersDto(
            users.getId(),
            users.getUserName(),
            users.getPassword(),
            users.getPhoneNumber(),
            users.getEmail(),
            users.getStatus(),
            users.getTypeID(),
            users.getSocialLoginId(),
            users.getCreateTime(),
            users.getIP()
        );
    }

    public static Users mapToUsers(UsersDto usersDto){
        return new Users(
            usersDto.getId(),
            usersDto.getUserName(),
            usersDto.getPassword(),
            usersDto.getPhoneNumber(),
            usersDto.getEmail(),
            usersDto.getStatus(),
            usersDto.getTypeID(),
            usersDto.getSocialLoginId(),
            usersDto.getCreateTime(),
            usersDto.getIP()
        );
    }
}
