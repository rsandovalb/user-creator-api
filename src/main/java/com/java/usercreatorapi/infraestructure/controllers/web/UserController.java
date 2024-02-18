package com.java.usercreatorapi.infraestructure.controllers.web;

import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;
import com.java.usercreatorapi.infraestructure.repositories.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.regex.Pattern;

@Slf4j
@Controller
@RequestMapping(path = "/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final Environment environment;

    private final IUserService userUseCase;


    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreationDTO user) {
        log.info("[CREATE USER] Creating a user (we hide the pass): {}",user.toString());
        return new ResponseEntity<>(userUseCase.createUser(user), HttpStatus.CREATED);
    }


}
