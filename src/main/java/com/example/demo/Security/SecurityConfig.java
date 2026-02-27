package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Essa classe é uma classe de configuração do Spring.
@Configuration
public class SecurityConfig {

    //Diz que o objeto retornado será gerenciado pelo Spring
    @Bean
    public PasswordEncoder senhaCriptografada() {
        return new BCryptPasswordEncoder();
    }

}
