package com.java.usercreatorapi.domain.mappers;

import com.java.usercreatorapi.domain.dto.PhoneDTO;
import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;
import com.java.usercreatorapi.domain.entities.Phone;
import com.java.usercreatorapi.domain.entities.User;
import com.java.usercreatorapi.domain.utils.TokenUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {

    public static User mapNewUser(UserCreationDTO userCreationDTO){
        User newUser = UserMapper.from(userCreationDTO);
        Date now = new Date();
        String id = String.valueOf(UUID.randomUUID());
        newUser.setCreated(now);
        newUser.setLastLogin(now);
        newUser.setModified(now);
        newUser.setId(id);
        newUser.setIsActive(true);
        if(userCreationDTO.hasPhones()){
            List<Phone> phones = to(userCreationDTO.getPhones(),newUser);
            newUser.setPhones(phones);
        }
        String token = TokenUtils.generateTokenFromUser(newUser,id);
        newUser.setToken(token);

        return newUser;
    }
    public static User from(UserCreationDTO userDTO) {
        User user = User.builder().email(userDTO.getEmail())
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .build();
        return user;

    }

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .created(user.getCreated())
                .id(user.getId())
                .isActive(user.getIsActive())
                .lastLogin(user.getLastLogin())
                .modified(user.getModified())
                .token(user.getToken())
                .build();
    }

    public static List<Phone> to(List<PhoneDTO> phones , User user){
        return phones.stream().map(phoneDTO -> new Phone(phoneDTO.getCitycode(), phoneDTO.getCountrycode(), phoneDTO.getNumber(), user)).collect(Collectors.toList());
    }
}
