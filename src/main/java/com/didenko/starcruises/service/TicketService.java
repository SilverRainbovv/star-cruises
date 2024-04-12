package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.TicketReadDto;
import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.mapper.TicketReadDtoMapper;
import com.didenko.starcruises.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class  TicketService {

    private final ClientService clientService;
    private final CruiseService cruiseService;
    private final SeatService seatService;
    private final TicketRepository ticketRepository;
    private final TicketReadDtoMapper ticketReadDtoMapper;

    @Transactional(readOnly = false)
    public Ticket createTicket(Long userId,Long cruiseId, Integer seatGroup){

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

        return ticket;
    }

    public List<TicketReadDto> findTicketsByUserId(Long userId){

        return ticketRepository.findTicketsByClientUserId(userId)
                .stream().map(ticketReadDtoMapper::mapFrom)
                .sorted(Comparator.comparing(ticket -> ticket.getTicketState().getOrder()))
                .toList();
    }
    @Transactional(readOnly = false)

    public Ticket cancelTicket(Long ticketId){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ticket.getSeat().setVacancy(SeatVacancy.VACANT);
        ticket.setState(TicketState.CANCELLED);

        return ticketRepository.save(ticket);
    }

    public Ticket findTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}