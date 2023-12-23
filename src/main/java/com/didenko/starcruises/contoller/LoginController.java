package com.didenko.starcruises.contoller;

import com.didenko.starcruises.dto.UserLoginDto;
import com.didenko.starcruises.dto.UserReadDto;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute UserLoginDto userLoginDto){
        Optional<UserReadDto> maybeUser = loginService.attemptLogin(userLoginDto);

        if (maybeUser.isEmpty()) {
            model.addAttribute("error");
            return "redirect:/login";
        } else {
            UserReadDto userReadDto = maybeUser.get();
            if (userReadDto.getRole().equals(Role.ADMIN)){
                return "redirect:/admin";
            } else {
                   return "redirect:/client";
            }
        }
    }

}
