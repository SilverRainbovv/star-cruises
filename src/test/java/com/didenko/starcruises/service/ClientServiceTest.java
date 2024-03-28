package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.mapper.ClientReadDtoMapper;
import com.didenko.starcruises.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    private static final Long CLIENT_ID = 1L;
    private static final String CLIENT_FIRSTNAME = "JOHN";
    private static final String CLIENT_LASTNAME = "GOLD";
    private static final LocalDate CLIENT_BIRTHDATE = LocalDate.of(1980, 10, 1);
    private static final String CLIENT_EMAIL = "johngold@gmail.com";
    private static final Role CLIENT_ROLE = Role.CLIENT;

    private static final Client CLIENT = Client.builder()
            .id(CLIENT_ID)
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


    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientReadDtoMapper clientReadDtoMapper;
    @InjectMocks
    private ClientService clientService;

    @Test
    void findClientReadDtoById() {
        Mockito.doReturn(Optional.of(CLIENT)).when(clientRepository).findById(CLIENT_ID);
        Mockito.doReturn(CLIENT_READ_DTO).when(clientReadDtoMapper).mapFrom(CLIENT);

        var searchResult = clientService.findClientReadDtoById(CLIENT_ID);

        assertTrue(searchResult.isPresent());
        assertEquals(CLIENT_READ_DTO, searchResult.get());

    }

    @Test
    void findClientEntityById() {
        Mockito.doReturn(Optional.of(CLIENT)).when(clientRepository).findById(CLIENT_ID);

        var searchResult = clientService.findClientEntityById(CLIENT_ID);

        assertTrue(searchResult.isPresent());
        assertEquals(CLIENT, searchResult.get());
    }
}