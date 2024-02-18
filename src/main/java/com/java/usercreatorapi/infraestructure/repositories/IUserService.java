package com.java.usercreatorapi.infraestructure.repositories;

import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;

public interface IUserService {
    UserDTO createUser(UserCreationDTO user);
}
