package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Client
public class ClientCreateEditDto {

    public ClientCreateEditDto(){
        documentDtos = new ArrayList<>();
    }

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private LocalDate birthdate;

    private List<ClientDocumentDto> documentDtos;

    public void addDocument(ClientDocumentDto clientDocumentDto){
        documentDtos.add(clientDocumentDto);
    }

}
