package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TicketService {

    private final ClientService clientService;
    private final CruiseService cruiseService;
    private final SeatService seatService;
    private final TicketRepository ticketRepository;

    @Transactional(readOnly = false)
    public void createTicket(Long userId,Long cruiseId, Integer seatGroup){

        Client client = clientService.findClientEntityById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Cruise cruise = cruiseService.findCruiseEntityById(cruiseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Seat seat = seatService.findVacantSeatByShipIdAndSeatGroup(cruise.getShip().getId(), seatGroup)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Ticket ticket = Ticket.builder()
                .state(TicketState.PENDING)
                .build();

        ticket.setClient(client);
        ticket.setCruise(cruise);
        ticket.setSeat(seat);

        seat.setVacancy(SeatVacancy.BOOKED);

        ticketRepository.save(ticket);
    }
}