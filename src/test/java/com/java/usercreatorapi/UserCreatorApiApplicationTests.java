package com.java.usercreatorapi;

import com.java.usercreatorapi.domain.dto.PhoneDTO;
import com.java.usercreatorapi.domain.dto.UserCreationDTO;
import com.java.usercreatorapi.domain.dto.UserDTO;
import com.java.usercreatorapi.domain.entities.User;
import com.java.usercreatorapi.domain.utils.TokenUtils;
import com.java.usercreatorapi.infraestructure.repositories.jpa.UserJPARepositoryImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Date;

@SpringBootTest
class UserCreatorApiApplicationTests {

	private Environment environment;
	private final Date now = new Date();
	private final String ID = "671bc9fd-7d81-4149-a369-9539163dd5f6";

	UserJPARepositoryImpl jpaRepository;
	TokenUtils tokenUtils;
	User user;
	User userWithoutPhones;
	UserCreationDTO userCreationDTO;

	@BeforeEach
	void setUp() {

		userCreationDTO = buildUserCreatio();
	}

	private UserCreationDTO buildUserCreatio() {
		return UserCreationDTO.builder()
				.email("ricardo@sandoval.org")
				.name("Ricardo Sandoval")
				.password("abC22")
				.phones(Arrays.asList(PhoneDTO.builder().number("1234567").citycode("1").countrycode("57").build()))
				.build();
	}



}
