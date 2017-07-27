package com.example.app.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.domain.model.Shouhin;
import com.example.domain.service.ShouhinService;

@Controller
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    ShouhinService shouhinService;

    @RequestMapping("sample")
    String loginForm(Model model) {
        Shouhin shouhin = shouhinService.findByShouhinIdAndShouhinVer("1234", new BigDecimal(1729));
        if (shouhin != null) {
            logger.info("shouhin.getShouhin()=" + shouhin.getShouhin());
            model.addAttribute("shouhin", shouhin);
        }
        return "sample";
    }
}
