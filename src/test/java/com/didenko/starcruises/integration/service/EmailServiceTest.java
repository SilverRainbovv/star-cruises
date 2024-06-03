package com.didenko.starcruises.integration.service;

import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailServiceTest extends BaseIntegrationTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void textMessageTest(){

        emailService.sendTextOnlyMessage("vadimdidenko13@gmail.com", "Star-Cruises",
                "test", "test message text");
    }

    @Test
    public void sendCancellationNotification(){
        emailService.notifyUsersOnCruiseCancel(102L);
    }

}