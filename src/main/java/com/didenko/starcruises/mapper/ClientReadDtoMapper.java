package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.dto.ClientDocumentDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ClientReadDtoMapper implements Mapper<Client, ClientReadDto> {

    private final ClientDocumentReadDtoMapper documentReadDtoMapper;

    @Override
    public ClientReadDto mapFrom(Client object) {
        User user = object.getUser();

        List<ClientDocumentDto> documentReadDtos = object.getDocuments().stream()
                .map(documentReadDtoMapper::mapFrom)
                .sorted(Comparator.comparing(doc -> doc.getState().getOrder()))
                .toList();

        ClientReadDto clientReadDto = new ClientReadDto(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                object.getFirstname(),
                object.getLastname(),
                object.getBirthdate());

        clientReadDto.setClientDocumentDtos(documentReadDtos);

        return clientReadDto;
    }
}
