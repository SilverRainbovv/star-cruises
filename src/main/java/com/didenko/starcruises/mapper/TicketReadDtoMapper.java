package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.TicketReadDto;
import com.didenko.starcruises.entity.Ticket;
import com.didenko.starcruises.entity.TicketState;
import org.springframework.stereotype.Component;

@Component
public class TicketReadDtoMapper implements Mapper<Ticket, TicketReadDto> {
    @Override
    public TicketReadDto mapFrom(Ticket ticket) {
        return TicketReadDto.builder()
                .ticketId(ticket.getId())
                .ship(ticket.getCruise().getShip().getName())
                .cruise(ticket.getCruise().getDescription())
                .price(ticket.getSeat().getPrice())
                .seatClass(ticket.getSeat().getSeatClass())
                .numberOfPersons(ticket.getSeat().getNumberOfPersons())
                .ticketState(ticket.getState())
                .isCanceled(ticket.getState().equals(TicketState.CANCELLED))
                .build();
    }
}
