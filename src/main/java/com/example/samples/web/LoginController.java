package com.example.samples.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("login")
    String loginForm(Model model) {
        model.addAttribute("aaa", "bbb");
        return "login";
    }
}
