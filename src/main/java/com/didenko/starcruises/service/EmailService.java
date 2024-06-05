package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final ClientService clientService;
    private final CruiseService cruiseService;

    private static final String COMPANY_EMAIL = "star-cruise-email-placeholder@gmail.com";
    private static final  String CRUISE_CANCELLATION_EMAIL_SUBJECT = "Cruise cancellation notification";
    private static final  String TICKET_ORDER_EMAIL_SUBJECT = "Cruise ticket from Star-Cruises";

    public void sendTextOnlyMessage(String to, String from,
                                    String subject, String messageText){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(subject);
        message.setText(messageText);

        emailSender.send(message);
    }

    @Transactional
    @Async("taskExecutor")
    public void notifyUsersOnCruiseCancel(Long cruiseId) {

        Set<Client> clientSet = clientService.findAllClientEmailByCruiseId(cruiseId);
        Cruise cruise = cruiseService.findCruiseEntityById(cruiseId).get();



        clientSet.forEach(client -> sendTextOnlyMessage(client.getUser().getEmail(),
                COMPANY_EMAIL,
                CRUISE_CANCELLATION_EMAIL_SUBJECT,
                String.format("""
                Good day Dear %s,\s
                We are sorry to inform you that cruise " %s " starting on %s has been canceled.\s
                Shortly our manager will contact you if you have already payed for your ticket.\s""",
                        client.getLastname(),
                        cruise.getDescription(), cruise.getFirstPort().getVisitDate())));
    }

    @Transactional
    @Async
    public void sendTicketEmail(Ticket ticket){

        String emailText = String.format("""
                Good day Dear %s, \s
                You have successfully made booking for the cruise "%s", on the vessel %s starting on %s at the port of %s.\s
                Your seat number is %s.
                Have a nice vacation!
                """,
                ticket.getClient().getLastname(),
                ticket.getCruise().getDescription(),
                ticket.getCruise().getShip().getName(),
                ticket.getCruise().getFirstPort().getVisitDate(),
                ticket.getCruise().getFirstPort().getName(),
                ticket.getSeat().getNumber());

        sendTextOnlyMessage(ticket.getClient().getUser().getEmail(),
                COMPANY_EMAIL,
                TICKET_ORDER_EMAIL_SUBJECT,
                emailText
                );

    }

}
