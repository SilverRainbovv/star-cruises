package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ClientCreateEditDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ClientCreateEditDtoMapper implements Mapper<ClientCreateEditDto, Client> {

    @Override
    public Client mapFrom(ClientCreateEditDto object) {

        User user = User.builder()
                .email(object.getEmail())
                .role(Role.CLIENT)
                .password(object.getPassword())
                .build();

        Client client = Client.builder()
                .firstname(object.getFirstname())
                .lastname(object.getLastname())
                .birthdate(object.getBirthdate())
                .build();

        client.setUser(user);

        return client;
    }

}
