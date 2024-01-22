package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.CruiseSearchDurationOptions;
import com.didenko.starcruises.entity.CruiseSortOptions;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.service.CruiseService;
import com.didenko.starcruises.service.ShipService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("cruise/{cruiseId}")
    public String editCruisePage(@PathVariable("cruiseId") Long cruiseId, Model model){

        Optional<CruiseCreateEditDto> cruise = cruiseService.findById(cruiseId);

        if(cruise.isEmpty()){
            return "redirect:/cruise";
        }

        model.addAttribute("cruiseCreateEditDto", cruise.get());
        model.addAttribute("ships", shipService.findAll());

        return "cruise";
    }

    @RequestMapping(value = "/cruise", params={"addPort", "ship"})
    public String addport(@ModelAttribute CruiseCreateEditDto cruiseCreateEditDto, BindingResult bindingResult,
                          Model model){

        cruiseCreateEditDto.addPort(new PortCreateEditDto());
        model.addAttribute("ships", shipService.findAll());

        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/cruise";
    }

    @RequestMapping(value = "/cruise", params = {"removePort", "ship"})
    public String removePort(@ModelAttribute CruiseCreateEditDto cruiseCreateEditDto, BindingResult bindingResult,
                             Model model, HttpServletRequest request){
        Integer rowId = Integer.valueOf(request.getParameter("removePort"));
        cruiseCreateEditDto.getPorts().remove(rowId.intValue());
        model.addAttribute("seatClasses", SeatClass.values());


        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/cruise";
    }

    @PostMapping(value = "cruise")
    public String saveCruise(@ModelAttribute CruiseCreateEditDto cruiseCreateEditDto){

        cruiseService.save(cruiseCreateEditDto);

        return "redirect:/cruises";

    }

}
