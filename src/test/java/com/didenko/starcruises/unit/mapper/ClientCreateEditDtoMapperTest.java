package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.ClientCreateEditDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import com.didenko.starcruises.mapper.ClientCreateEditDtoMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientCreateEditDtoMapperTest {

    private static final String CLIENT_FIRSTNAME = "JOHN";
    private static final String CLIENT_LASTNAME = "GOLD";
    private static final LocalDate CLIENT_BIRTHDATE = LocalDate.of(1980, 10, 1);
    private static final String CLIENT_EMAIL = "johngold@gmail.com";
    private static final String CLIENT_PASSWORD = "123";

    private static final Client CLIENT = Client.builder()
            .firstname(CLIENT_FIRSTNAME)
            .lastname(CLIENT_LASTNAME)
            .birthdate(CLIENT_BIRTHDATE)
            .build();

    private static final User USER = User.builder()
            .role(Role.CLIENT)
            .email(CLIENT_EMAIL)
            .password(CLIENT_PASSWORD)
            .build();

    private static final ClientCreateEditDto CLIENT_CREATE_EDIT_DTO = ClientCreateEditDto.builder()
            .firstname(CLIENT_FIRSTNAME)
            .lastname(CLIENT_LASTNAME)
            .birthdate(CLIENT_BIRTHDATE)
            .email(CLIENT_EMAIL)
            .password(CLIENT_PASSWORD)
            .build();

    private final ClientCreateEditDtoMapper clientCreateEditDtoMapper = new ClientCreateEditDtoMapper();

    @BeforeAll
    static void prepareClient(){
        CLIENT.setUser(USER);
    }

    @Test
    void testMapping(){
        assertEquals(CLIENT, clientCreateEditDtoMapper.mapFrom(CLIENT_CREATE_EDIT_DTO));
    }

}