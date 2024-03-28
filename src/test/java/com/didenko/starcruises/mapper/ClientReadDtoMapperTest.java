package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientReadDtoMapperTest {

    private static final Long CLIENT_ID = 1L;
    private static final String CLIENT_FIRSTNAME = "JOHN";
    private static final String CLIENT_LASTNAME = "GOLD";
    private static final LocalDate CLIENT_BIRTHDATE = LocalDate.of(1980, 10, 1);
    private static final String CLIENT_EMAIL = "johngold@gmail.com";
    private static final Role CLIENT_ROLE = Role.CLIENT;
    private static final String CLIENT_PASSWORD = "123";

    private static final Client CLIENT = Client.builder()
            .firstname(CLIENT_FIRSTNAME)
            .lastname(CLIENT_LASTNAME)
            .birthdate(CLIENT_BIRTHDATE)
            .build();

    private static final ClientReadDto CLIENT_READ_DTO = new ClientReadDto(
            CLIENT_ID,
            CLIENT_EMAIL,
            CLIENT_ROLE,
            CLIENT_FIRSTNAME,
            CLIENT_LASTNAME,
            CLIENT_BIRTHDATE);

    private static final User USER = User.builder()
            .id(CLIENT_ID)
            .role(Role.CLIENT)
            .email(CLIENT_EMAIL)
            .password(CLIENT_PASSWORD)
            .build();

    @BeforeAll
    static void prepareClient(){
        CLIENT.setUser(USER);
    }

    @Mock
    private ClientDocumentReadDtoMapper documentReadDtoMapper;
    @InjectMocks
    private ClientReadDtoMapper mapper;

    @Test
    void mapFrom() {
        assertEquals(CLIENT_READ_DTO, mapper.mapFrom(CLIENT));
    }

}