package com.didenko.starcruises.contoller;

import com.didenko.starcruises.service.CruiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final CruiseService cruiseService;

    @GetMapping("/admin")
    public String adminPage(Model model){

        var cruises = cruiseService.allCruises();
        model.addAttribute("cruises", cruises);
//        model.addAttribute("cruises", cruiseService.allCruises());

        return "admin";
    }

}
