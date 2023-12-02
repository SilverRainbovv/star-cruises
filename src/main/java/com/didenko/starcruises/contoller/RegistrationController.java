package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.ClientCreateEditDto;
import com.didenko.starcruises.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@RequestMapping("registration")
@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String registrationPage(){
        return "registration";
    }

    @PostMapping
    public String registration(@Validated @ModelAttribute ClientCreateEditDto clientDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("client", clientDto);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/registration";
        }
        registrationService.register(clientDto);

        return "redirect:/login";
    }
}