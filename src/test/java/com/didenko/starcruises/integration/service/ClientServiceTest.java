package com.didenko.starcruises.integration.service;

import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceTest extends BaseIntegrationTest {

    @Autowired
    private ClientService clientService;

    @Test
    public void findAllClientsByCruiseId(){

        var emails = clientService.findAllClientEmailByCruiseId(114L);

        Assertions.assertTrue(emails.size() == 3);
    }

}