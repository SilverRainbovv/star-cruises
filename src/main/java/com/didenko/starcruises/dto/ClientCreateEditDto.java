package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.Client;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Client
public class ClientCreateEditDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @Size(min = 3, max = 64)
    @NotBlank
    private String firstname;

    @Size(min = 3, max = 64)
    @NotBlank
    private String lastname;

    private LocalDate birthdate;

    @Builder.Default
    private List<ClientDocumentDto> documentDtos = new ArrayList<>();

}
