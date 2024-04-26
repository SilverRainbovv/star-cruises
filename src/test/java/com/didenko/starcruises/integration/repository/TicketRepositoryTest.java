package com.didenko.starcruises.integration.repository;

import com.didenko.starcruises.entity.TicketState;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest extends BaseIntegrationTest {

    private static final Long FIND_BY_CLIENT_USER_ID_USER_ID = 111L;
    private static final int FIND_BY_CLIENT_USER_ID_TICKETS_NUMBER = 2;

    //(1010, 102, 1129, 116, 'PAID'),
    //(id, cruise_id, seat_id, client_id, state)
    private static final Long FIND_BY_ID_TICKET_ID = 1010L;
    private static final Long FIND_BY_ID_CRUISE_ID = 102L;
    private static final Long FIND_BY_ID_SEAT_ID = 1129L;
    private static final Long FIND_BY_ID_CLIENT_ID = 116L;
    private static final TicketState FIND_BY_ID_TICKET_STATE = TicketState.PAID;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void findTicketsById() {
        var maybeTicket = ticketRepository.findById(FIND_BY_ID_TICKET_ID);

        assertTrue(maybeTicket.isPresent());
        assertEquals(FIND_BY_ID_TICKET_ID, maybeTicket.get().getId());
        assertEquals(FIND_BY_ID_CRUISE_ID, maybeTicket.get().getCruise().getId());
        assertEquals(FIND_BY_ID_SEAT_ID, maybeTicket.get().getSeat().getId());
        assertEquals(FIND_BY_ID_CLIENT_ID, maybeTicket.get().getClient().getId());
        assertEquals(FIND_BY_ID_TICKET_STATE, maybeTicket.get().getState());
    }

    @Test
    void findTicketsByClientUserId() {
        var userTickets = ticketRepository.findTicketsByClientUserId(FIND_BY_CLIENT_USER_ID_USER_ID);

        assertEquals(FIND_BY_CLIENT_USER_ID_TICKETS_NUMBER, userTickets.size());
    }
}