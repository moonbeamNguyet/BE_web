package net.javaguides.CD_Web_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.CD_Web_backend.dto.UsersDto;
import net.javaguides.CD_Web_backend.entity.Users;
import net.javaguides.CD_Web_backend.mapper.UsersMapper;
import net.javaguides.CD_Web_backend.repository.UsersRepository;
import net.javaguides.CD_Web_backend.service.UsersService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceIpml implements UsersService{
    private UsersRepository usersRepository;

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        Users users = UsersMapper.mapToUsers(usersDto);
        Users saveUsers = usersRepository.save(users);
        return UsersMapper.mapToUsersDto(saveUsers);
    }

    @Override
    public UsersDto getUserByEmailAndPassWord(String email, String password) {
        Users users = usersRepository.findByEmailAndPassword(email, password);
        if (users == null) {
            return null;
        }
        return UsersMapper.mapToUsersDto(users);
    }
}
