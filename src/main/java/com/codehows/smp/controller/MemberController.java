package com.codehows.smp.controller;

import com.codehows.smp.dto.MemberFormDto;
import com.codehows.smp.entity.Member;
import com.codehows.smp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping(value = "/login")
    public String login() {
        return "pages/member/loginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "exception", required = false) String exception,
                             Model model) {
        System.out.println(error);
        System.out.println(exception);
        return "pages/member/loginForm";
    }

    @GetMapping(value = "/new")
    public String userForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "pages/member/userForm";
    }

    @PostMapping(value = "/new")
    public String newMember(MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "pages/member/loginForm";
        }
        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "pages/member/userForm";
        }
        return "redirect:/member/login";
    }
}
