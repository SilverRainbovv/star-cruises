package com.didenko.starcruises.repository;

import com.didenko.starcruises.integration.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest extends BaseIntegrationTest {

    private static final Long USER_ID_1 = 101L;
    private static final Long CLIENT_ID_1 = 101L;
    private static final String USER_EMAIL_1 = "vadimdidenko@gmail.com";
    private static final String CLIENT_1_FIRSTNAME = "John";
    private static final String CLIENT_1_LASTNAME = "Doe";
    private static final LocalDate CLIENT_1_BIRTHDATE = LocalDate.of(1984, 4, 16);
    private static final Integer CLIENT_1_TICKETS_NUMBER = 1;

    private static final Long SEARCH_BY_EMAIL_CLIENT_ID = 111L;
    private static final String SEARCH_BY_EMAIL_USER_EMAIL = "potteea@php.net";

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void findById(){
        var maybeUser = clientRepository.findById(USER_ID_1);

        assertTrue(maybeUser.isPresent());
        assertEquals(USER_ID_1, maybeUser.get().getId());
        assertEquals(CLIENT_ID_1, maybeUser.get().getUser().getId());
        assertEquals(USER_EMAIL_1, maybeUser.get().getUser().getEmail());
        assertEquals(CLIENT_1_FIRSTNAME, maybeUser.get().getFirstname());
        assertEquals(CLIENT_1_LASTNAME, maybeUser.get().getLastname());
        assertEquals(CLIENT_1_BIRTHDATE, maybeUser.get().getBirthdate());
        assertEquals(CLIENT_1_TICKETS_NUMBER, maybeUser.get().getTickets().size());
    }

    @Test
    void findByUserEmail() {
        var maybeUser = clientRepository.findByUserEmail(SEARCH_BY_EMAIL_USER_EMAIL);

        assertTrue(maybeUser.isPresent());
        assertEquals(SEARCH_BY_EMAIL_CLIENT_ID, maybeUser.get().getId());
        assertEquals(SEARCH_BY_EMAIL_USER_EMAIL, maybeUser.get().getUser().getEmail());
    }
}