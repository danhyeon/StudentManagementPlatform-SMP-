package com.codehows.smp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/class")
@Controller
@RequiredArgsConstructor
public class ClassManageController {
    @GetMapping(value = "/info")
    public String infoManage() {
        return "pages/classManage/classInfo";
    }
}
