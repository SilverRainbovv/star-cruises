package com.didenko.starcruises.configuration;


import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @SneakyThrows
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http.csrf(csrf -> csrf.disable())
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/user"))
                .logout(logout -> logout.logoutSuccessUrl("/cruises"))
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
