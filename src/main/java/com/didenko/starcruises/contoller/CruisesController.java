package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.*;
import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.service.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("cruises")
@Controller
public class CruisesController {

    private final CruiseService cruiseService;
    private final ShipService shipService;
    private final SeatService seatService;
    private final TicketService ticketService;

    @GetMapping
    public String cruisesPage(Model model, @RequestParam(value = "ship_name", required = false) String shipName,
                              @RequestParam(value = "departure_port", required = false) String departurePort,
                              @RequestParam(value = "departure_after", required = false) LocalDate departureAfter,
                              @RequestParam(value = "nights", required = false) CruiseSearchDurationOptions nights,
                              @RequestParam(value = "sortBy", required = false) CruiseSortOptions sortOption,
                              Pageable pageable){

        List<ShipReadDto> shipReadDtos = shipService.findAll();

        SearchOptions searchOptions =  new SearchOptions(
                shipName == null || shipName.isEmpty() || shipName.equals("ANY") ? "" : shipName,
                departurePort == null || departurePort.isEmpty() ? "" : departurePort,
                departureAfter,
                nights == null ? CruiseSearchDurationOptions.ANY : nights,
                sortOption);

        List<CruiseReadDto> cruises = cruiseService.findAllCruisesWithFilter(sortOption, searchOptions);

        model.addAttribute("searchOptions", searchOptions);

        model.addAttribute("cruises", cruises);
        model.addAttribute("ships", shipReadDtos);
        model.addAttribute("cruiseSearchDurationOptions", CruiseSearchDurationOptions.values());
        model.addAttribute("cruiseSortOptions", CruiseSortOptions.values());

        return "cruises";
    }

    @GetMapping("/{cruiseId}/book")
    public String bookingPage(@PathVariable("cruiseId") Long cruiseId, Model model){

        Optional<CruiseReadDto> cruise = cruiseService.findReadDtoById(cruiseId);
        List<SeatReadDto> seats = seatService.findSeatsByCruiseId(cruiseId);

        if (cruise.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        model.addAttribute("cruise", cruise.get());
        model.addAttribute("seats", seats);

        return "/booking";
    }

    @GetMapping("cruise")
    public String createCruisePage(Model model){

        model.addAttribute("cruiseCreateEditDto", new CruiseCreateEditDto());
        model.addAttribute("ships", shipService.findAll());

        return "cruise";
    }

    @GetMapping("cruise/{cruiseId}")
    public String editCruisePage(@PathVariable("cruiseId") Long cruiseId, Model model){

        Optional<CruiseCreateEditDto> cruise = cruiseService.findEditDtoById(cruiseId);

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

    @GetMapping(value = "/{cruiseId}/book/{seatGroup}")
    public String bookSeat(@PathVariable("cruiseId") Long cruiseId, @PathVariable("seatGroup") Integer seatGroup,
                         @AuthenticationPrincipal User curentUser){

        return "redirect:/user";
    }

}