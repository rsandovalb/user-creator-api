package com.java.usercreatorapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phones")
public class Phone {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long id;
    private String number;
    private String cityCode;
    private String countryCode;

    public Phone(String number, String cityCode, String countryCode, User user){
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.user = user;

    }

}
