package com.java.usercreatorapi.infraestructure.repositories.jpa;

import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;
import com.java.usercreatorapi.domain.entities.User;
import com.java.usercreatorapi.domain.mappers.UserMapper;
import com.java.usercreatorapi.infraestructure.repositories.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserJPARepositoryImpl implements IUserService {

    private final IUserJPARepository userJPARepository;

    @Override
    public UserDTO createUser(UserCreationDTO user) {
        User userEntity =  userJPARepository.save(UserMapper.mapNewUser(user));
        return UserMapper.from(userEntity);
    }

}
