package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.Role;
import lombok.Data;

@Data
public class UserReadDto {

    private final Long id;

    private final String email;

    private final Role role;

    public UserReadDto(Long id, String email, Role role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
}
