package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.service.ShipService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/ship/{id}")
    public String editShipPage(@PathVariable Long id, Model model){

        Optional<ShipCreateEditDto> ship = shipService.findById(id);

        model.addAttribute("shipCreateEditDto", ship.get());
        model.addAttribute("seatClasses", SeatClass.values());

        return "/ship";
    }

    @GetMapping("/ship")
    public String createShipPage(Model model){
        model.addAttribute("shipCreateEditDto", new ShipCreateEditDto());
        model.addAttribute("seatClasses", SeatClass.values());

        return "/ship";
    }

    @PostMapping( value = "/ship")
    public String saveShip(@ModelAttribute ShipCreateEditDto shipCreateEditDto){

        shipService.save(shipCreateEditDto);

        return "redirect:/ships";
    }

    @RequestMapping(value="/ship", params={"addSeat"})
    public String addSeats(@ModelAttribute ShipCreateEditDto shipCreateEditDto,
                          BindingResult bindingResult,
                          Model model) {
        shipCreateEditDto.addSeat(new SeatCreateEditDto());

        model.addAttribute("seatClasses", SeatClass.values());
        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/ship";
    }

    @RequestMapping(value = "/ship", params = "removeSeats")
    public String removeSeats(@ModelAttribute ShipCreateEditDto shipCreateEditDto,
                              BindingResult bindingResult,
                              Model model, HttpServletRequest request){
        Integer rowId = Integer.valueOf(request.getParameter("removeSeats"));
        shipCreateEditDto.getSeats().remove(rowId.intValue());
        model.addAttribute("seatClasses", SeatClass.values());
        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/ship";
    }

}
