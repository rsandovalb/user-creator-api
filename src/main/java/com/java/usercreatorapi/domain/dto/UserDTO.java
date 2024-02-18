package com.java.usercreatorapi.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDTO {

    private String id;
    private Boolean isActive;
    private String token;
    private Date created;
    private Date modified;
    private Date lastLogin;

}
