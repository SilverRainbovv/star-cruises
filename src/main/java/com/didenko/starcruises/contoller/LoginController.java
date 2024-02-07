package com.didenko.starcruises.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

//    @PostMapping("/login")
//    public String login(Model model, @ModelAttribute UserLoginDto userLoginDto){
//        Optional<UserReadDto> maybeUser = loginService.attemptLogin(userLoginDto);
//
//        if (maybeUser.isEmpty()) {
//            model.addAttribute("error");
//            return "redirect:/login";
//        } else {
//            UserReadDto userReadDto = maybeUser.get();
//            if (userReadDto.getRole().equals(Role.ADMIN)){
//                return "redirect:/admin";
//            } else {
//                   return "redirect:/client";
//            }
//        }
//    }

}
