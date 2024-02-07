package com.didenko.starcruises.contoller;

import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping
    public String redirectSuccessfulLogin(@AuthenticationPrincipal User user){
        return user.getRole().equals(Role.ADMIN)
                ? "redirect:/admin"
                : "redirect:/client";
    }

}
