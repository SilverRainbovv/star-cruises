package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.Role;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ClientReadDto extends UserReadDto{

    public ClientReadDto(Long id, String email, Role role, String firstname, String lastname, LocalDate birthdate) {
        super(id, email, role);
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.clientDocumentDtos = new ArrayList<>();
        newDocument = Optional.empty();
    }

    private final String firstname;

    private final String lastname;

    private final LocalDate birthdate;

    @Getter
    @Setter
    private Optional<MultipartFile> newDocument;

    @Setter
    private List<ClientDocumentDto> clientDocumentDtos;

    public void addDocument(ClientDocumentDto clientDocumentDto){
        clientDocumentDtos.add(clientDocumentDto);
    }

}
