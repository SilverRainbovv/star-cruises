package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.*;
import com.didenko.starcruises.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/client")
@RequiredArgsConstructor
@Controller
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{clientId}")
    public String clientPage(@PathVariable("clientId") Long clientId, Model model){

        model.addAttribute("clientReadDto", clientService.findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        return "clientPage";
    }

    @RequestMapping(params={"addDocument"})
    public String addDocument(@ModelAttribute ClientReadDto clientReadDto, BindingResult bindingResult,
                             Model model){

        clientReadDto.addDocument(new ClientDocumentDto());
        model.addAttribute("clientReadDto", clientReadDto);

        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/clientPage";
    }

    @RequestMapping(params = {"removeDocument"})
    public String removeDocument(@ModelAttribute ClientReadDto clientReadDto, BindingResult bindingResult,
                             Model model, HttpServletRequest request){
        Integer rowId = Integer.valueOf(request.getParameter("removeDocument"));
        clientReadDto.getClientDocumentDtos().remove(rowId.intValue());
        model.addAttribute("clientReadDto", clientReadDto);

        if (bindingResult.hasErrors()){
            System.out.println();
        }
        return "/clientPage";
    }

    @PostMapping
    public String updateClient(@ModelAttribute ClientReadDto clientReadDto){
        clientService.update(clientReadDto);

        return "redirect:/client/" + clientReadDto.getId();
    }
}
