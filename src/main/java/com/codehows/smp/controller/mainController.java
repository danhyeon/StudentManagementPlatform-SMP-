package com.codehows.smp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class mainController {
    @GetMapping(value="/")
    public String main() {
        return "pages/main";
    }
}
