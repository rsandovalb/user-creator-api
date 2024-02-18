package com.java.usercreatorapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String name;

    private String email;

    private String password;

    @Column(length = 500)
    private String token;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<Phone> phones;

    @Column(name = "is_active")
    private Boolean isActive;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modified;

    @Column(name = "last_login")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLogin;

}
