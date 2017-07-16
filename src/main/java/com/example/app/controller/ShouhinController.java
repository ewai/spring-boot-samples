package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShouhinController {

    @RequestMapping("shouhin")
    String loginForm(Model model) {
        model.addAttribute("aaa", "bbb");
        return "shouhin";
    }
}
