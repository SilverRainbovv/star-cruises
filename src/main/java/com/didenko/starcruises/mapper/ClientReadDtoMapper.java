package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ClientReadDtoMapper implements Mapper<Client, ClientReadDto> {
    @Override
    public ClientReadDto mapFrom(Client object) {
        User user = object.getUser();
        return new ClientReadDto(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                object.getFirstname(),
                object.getLastname(),
                object.getBirthdate()
        );
    }
}
