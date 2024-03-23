package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.CompletedOrder;
import com.didenko.starcruises.service.PayPalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paypal")
public class PaymentRestController {

    private final PayPalService payPalService;

    @PostMapping(value = "/capture")
    public CompletedOrder completePayment(@RequestParam("token") String token) {
        return payPalService.completePayment(token);
    }
}
