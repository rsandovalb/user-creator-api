package com.java.usercreatorapi.domain.configuration;

import com.java.usercreatorapi.domain.utils.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@AllArgsConstructor
public class TokenUtilConfiguration {
    private final Environment environment;

    @Bean
    public TokenUtils instantiateTokenUtils(){
        return new TokenUtils(environment);
    }
}
