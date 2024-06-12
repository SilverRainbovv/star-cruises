package com.didenko.starcruises.configuration;


import com.didenko.starcruises.entity.Role;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
                .authorizeHttpRequests(urlConfig -> urlConfig.requestMatchers("/login",
                        "/cruises", "/registration", "/logout", "/css/**", "/js/**", "/images/**",
                                "/api/v1/**", "/ships/**", "/user/**", "/admin/**")
                        .permitAll()
                        .requestMatchers( "/cruises/cruise/**",
                                "/cruises/cruise/cancel/**", "/document/**",
                                "/ships/ship/**")
                        .hasAuthority(Role.ADMIN.getAuthority())
                        .requestMatchers("/client/**", "/cruises/{cruiseId}/book/**",
                                "/ticket/**")
                        .hasAuthority(Role.CLIENT.getAuthority()))
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/user", true))
                .logout(logout -> logout.logoutSuccessUrl("/cruises"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
