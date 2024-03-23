package com.didenko.starcruises.payment;

import com.didenko.starcruises.entity.Ticket;
import lombok.Getter;

@Getter
public class OrderDetails {

    private Ticket ticket;

    public String getSubtotal() {
        return String.format("%.2f", ticket.getSeat().getPrice());
    }
}
