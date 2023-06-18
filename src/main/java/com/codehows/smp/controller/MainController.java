package com.codehows.smp.controller;

import com.codehows.smp.dto.MemberFormDto;
import com.codehows.smp.entity.Member;
import com.codehows.smp.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping(value="/")
    public String main() {
        return "pages/main";
    }

}
