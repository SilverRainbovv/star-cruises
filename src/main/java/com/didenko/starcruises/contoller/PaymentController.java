package com.didenko.starcruises.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("payment")
@Controller
public class PaymentController {

    @GetMapping("/success")
    public String successPage(){
        return "success";
    }

    @GetMapping("/cancel")
    public String cancelPage(){
        return "cancel";
    }

}
