package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Cruise;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final ClientService clientService;
    private final CruiseService cruiseService;

    private static final String COMPANY_EMAIL = "star-cruise-email-placeholder@gmail.com";

    public void sendTextOnlyMessage(String to, String from,
                                    String subject, String messageText){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(messageText);

        emailSender.send(message);
    }

    public void notifyUsersOnCruiseCancel(Long cruiseId) {

        Set<Client> clientSet = clientService.findAllClientEmailByCruiseId(cruiseId);
        Cruise cruise = cruiseService.findCruiseEntityById(cruiseId).get();

        String emailSubject = "Cruise cancellation notification";

        clientSet.forEach(client -> sendTextOnlyMessage(client.getUser().getEmail(),
                COMPANY_EMAIL,
                emailSubject,
                String.format("""
                Good day Dear %s,\s
                We are sorry to inform you that cruise " %s " starting on %s has been canceled.\s
                Shortly our manager will contact you if you have already payed for your ticket.\s""",
                        client.getLastname(),
                        cruise.getDescription(), cruise.getFirstPort().getVisitDate())));
    }
}
