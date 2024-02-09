package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.TicketState;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TicketReadDto {

    private Long ticketId;

    private String ship;

    private String cruise;

    private BigDecimal price;

    private SeatClass seatClass;

    private Integer numberOfPersons;

    private TicketState ticketState;

    private boolean isCanceled;

}
