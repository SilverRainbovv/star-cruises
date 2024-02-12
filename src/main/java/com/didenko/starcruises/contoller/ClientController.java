package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.*;
import com.didenko.starcruises.entity.ClientDocumentState;
import com.didenko.starcruises.entity.User;
import com.didenko.starcruises.service.ClientService;
import com.didenko.starcruises.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/client")
@RequiredArgsConstructor
@Controller
public class ClientController {

    private final ClientService clientService;
    private  final TicketService ticketService;

    @GetMapping
    public String clientPage(@AuthenticationPrincipal User user, Model model){

        ClientReadDto clientReadDto = clientService.findClientReadDtoById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("clientReadDto",clientReadDto);

        model.addAttribute("canBook", clientReadDto.getClientDocumentDtos().stream()
                .anyMatch(document -> document.getState().equals(ClientDocumentState.APPROVED)));

        model.addAttribute("tickets", ticketService.findTicketsByUserId(user.getId()));

        return "clientPage";
    }

    @PostMapping
    public String updateClient(@ModelAttribute ClientReadDto clientReadDto){
        clientService.update(clientReadDto);

        return "redirect:/client";
    }
}
