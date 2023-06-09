package com.codehows.smp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/student")
@Controller
@RequiredArgsConstructor
public class studentManageController {
    @GetMapping(value = "/info")
    public String infoManage() {
        return "pages/studentManage/studentInfo";
    }
}
