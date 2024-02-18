package com.java.usercreatorapi.infraestructure.repositories.jpa;

import com.java.usercreatorapi.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPARepository extends JpaRepository<User, String> {
}
