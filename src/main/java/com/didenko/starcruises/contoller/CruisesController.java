package com.didenko.starcruises.contoller;

import com.didenko.starcruises.service.CruiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CruisesController {

    private final CruiseService cruiseService;

    @GetMapping("/cruises")
    public String cruisesPage(Model model){

        model.addAttribute("cruises", cruiseService.allCruises());

        return "cruises";
    }

}
