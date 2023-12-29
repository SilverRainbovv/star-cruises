package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.SeatCreateDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("ships")
@Controller
public class ShipController {

    private final ShipService shipService;

    @GetMapping
    public String shipsPage(Model model){
        model.addAttribute("ships", shipService.findAll());

        return "/ships";
    }

    @GetMapping("/ship")
    public String createShipPage(Model model){
        model.addAttribute("shipCreateEditDto", new ShipCreateEditDto());
        model.addAttribute("seatClasses", SeatClass.values());

        return "/ship";
    }

    @PostMapping( value = "/ship")
    public String createShip(@ModelAttribute ShipCreateEditDto shipCreateEditDto){
        shipService.save(shipCreateEditDto);

        return "redirect:/ships";
    }

    @RequestMapping(value="/ship", params={"addSeat"})
    public String addSeat(@ModelAttribute ShipCreateEditDto shipCreateEditDto, BindingResult bindingResult,
                          Model model) {
        shipCreateEditDto.addSeat(new SeatCreateDto());

        model.addAttribute("seatClasses", SeatClass.values());
        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/ship";
    }

}
