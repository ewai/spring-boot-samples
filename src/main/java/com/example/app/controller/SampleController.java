package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("sample")
    String loginForm(Model model) {
    		model.addAttribute("aaa", "bbb");
        return "sample";
    }
}
