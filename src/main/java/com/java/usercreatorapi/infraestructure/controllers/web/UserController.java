package com.java.usercreatorapi.infraestructure.controllers.web;

import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;
import com.java.usercreatorapi.domain.exceptions.ValidatorException;
import com.java.usercreatorapi.infraestructure.repositories.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final Environment environment;

    private final IUserService userUseCase;

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreationDTO user) {
        String regex = environment.getProperty("validator.password.regex","^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

        log.info("[CREATE USER] Creating a user (we hide the pass): {}",user.toString());

        if (!Pattern.matches(regex, user.getPassword())) {
            throw new ValidatorException(String.format("Password doesn't match with regex (%s) ", regex), HttpStatus.BAD_REQUEST);
        }
        log.info("[CREATE-USER] Creating a user: {}",user.toString());
        return new ResponseEntity<>(userUseCase.createUser(user), HttpStatus.CREATED);
    }


}
