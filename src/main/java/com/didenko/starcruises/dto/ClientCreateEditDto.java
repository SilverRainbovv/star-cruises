package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Client
@Value(staticConstructor = "of")
public class ClientCreateEditDto {

    @Email
    @NotNull
    String email;

    @NotNull
    String password;

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @NotNull
    LocalDate birthdate;

}
