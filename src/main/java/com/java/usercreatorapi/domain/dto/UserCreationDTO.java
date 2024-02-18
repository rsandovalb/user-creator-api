package com.java.usercreatorapi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserCreationDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private List<PhoneDTO> phones;

    @Override
    public String toString() {
        return "UserCreationDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                '}';
    }

    public boolean hasPhones() {
       return phones != null;
    }
}
