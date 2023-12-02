package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientReadDto extends UserReadDto{

    public ClientReadDto(Long id, String email, Role role, String firstname, String lastname, LocalDate birthdate) {
        super(id, email, role);
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    private final String firstname;

    private final String lastname;

    private final LocalDate birthdate;

}
