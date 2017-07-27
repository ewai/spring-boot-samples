package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TryThymeleafController {

    @RequestMapping("thymeleaf")
    String load(Model model) {

        model.addAttribute("test", "123");

        return "thymeleaf";
    }
}
