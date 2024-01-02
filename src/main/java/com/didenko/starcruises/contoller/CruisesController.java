package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.CruiseSearchDurationOptions;
import com.didenko.starcruises.entity.CruiseSortOptions;
import com.didenko.starcruises.service.CruiseService;
import com.didenko.starcruises.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("cruises")
@Controller
public class CruisesController {

    private final CruiseService cruiseService;
    private final ShipService shipService;

    @GetMapping
    public String cruisesPage(Model model){

        model.addAttribute("cruises", cruiseService.allCruises());
        model.addAttribute("ships", shipService.findAll());
        model.addAttribute("cruiseSearchDurationOptions", CruiseSearchDurationOptions.values());
        model.addAttribute("cruiseSortOptions", CruiseSortOptions.values());

        return "cruises";
    }

    @GetMapping("cruise")
    public String createCruisePage(Model model){

        model.addAttribute("cruiseCreateEditDto", new CruiseCreateEditDto());
        model.addAttribute("ships", shipService.findAll());

        return "cruise";
    }

    @RequestMapping(value = "/cruise", params={"addPort", "ship"})
    public String createCruise(@ModelAttribute CruiseCreateEditDto cruiseCreateEditDto, BindingResult bindingResult,
                            Model model){

        cruiseCreateEditDto.addPort(new PortCreateEditDto());
        model.addAttribute("ships", shipService.findAll());

        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/cruise";
    }

    @PostMapping(value = "cruise")
    public String createCruise(@ModelAttribute CruiseCreateEditDto cruiseCreateEditDto){

        cruiseService.save(cruiseCreateEditDto);

        return "redirect:/cruises";

    }

}
