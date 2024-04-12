package com.didenko.starcruises.integration.service;

import com.didenko.starcruises.entity.Ticket;
import com.didenko.starcruises.entity.TicketState;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest extends BaseIntegrationTest {

    private static final Long USER_ID = 106L;
    private static final Integer USER_TICKETS_NUMBER = 2;

    private static final Long TICKET_ID = 1008L;
    private static final Long CRUISE_ID = 113L;
    private static final Long SEAT_ID = 1015L;
    private static final Long CLIENT_ID = 111L;
    private static final TicketState TICKET_STATE = TicketState.CANCELLED;

    private static final Long TICKET_TO_CANCEL_ID = 1009L;

    @Autowired
    private TicketService ticketService;

    @Test
    void createTicket() {
        Ticket ticketToSave = ticketService.createTicket(102L, 101L, 1);

        assertNotNull(ticketToSave.getId());
    }

    @Test
    void findTicketsByUserId() {
        var tickets = ticketService.findTicketsByUserId(USER_ID);

        assertEquals(tickets.size(), USER_TICKETS_NUMBER);
    }

    @Test
    void findTicketById() {
        var ticket = ticketService.findTicketById(TICKET_ID);

        assertEquals(ticket.getId(), TICKET_ID);
        assertEquals(ticket.getClient().getId(), CLIENT_ID);
        assertEquals(ticket.getCruise().getId(), CRUISE_ID);
        assertEquals(ticket.getState(), TICKET_STATE);
        assertEquals(ticket.getSeat().getId(), SEAT_ID);
    }

    @Test
    void cancelTicket() {
        var canceledTicket = ticketService.cancelTicket(TICKET_TO_CANCEL_ID);

        assertEquals(TicketState.CANCELLED, canceledTicket.getState());
    }
}