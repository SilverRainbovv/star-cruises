package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.PaymentOrder;
import com.didenko.starcruises.service.PayPalService;
import com.didenko.starcruises.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ticket")
@RequiredArgsConstructor
@Controller
public class TicketController {

    private final TicketService ticketService;
    private final PayPalService payPalService;

    @GetMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable("ticketId") Long ticketId){

        ticketService.cancelTicket(ticketId);

        return "redirect:/user";
    }

    @GetMapping("/pay/{ticketId}")
    public PaymentOrder createPayment(
            @PathVariable("ticketId") Long ticketId) {
        return payPalService.createPayment(ticketService.findTicketsById(ticketId));
    }
}
