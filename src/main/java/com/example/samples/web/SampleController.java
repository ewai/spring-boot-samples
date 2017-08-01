package com.example.samples.web;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;

@Controller
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    ShouhinService shouhinService;

    @RequestMapping(value="/sample", method=RequestMethod.GET)
    String loginForm(@ModelAttribute Shouhin shouhinForm, Model model) {

        Shouhin shouhin = shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729));
        if (shouhin != null) {
            shouhinForm.setShouhinId(shouhin.getShouhinId());
            shouhinForm.setShouhin(shouhin.getShouhin());
        } else {
            shouhinForm.setShouhinId("shouhinId");
            shouhinForm.setShouhin("");
        }
        model.addAttribute("shouhinForm", shouhinForm);
        return "sample";
    }

    @RequestMapping(value="/sample", method=RequestMethod.POST)
    String save(@ModelAttribute Shouhin shouhinForm, Model model) {
        logger.info("shouhin.getShouhinId()=" + shouhinForm.getShouhinId());

        shouhinForm.setShouhin("shouhin");
        model.addAttribute("shouhinForm", shouhinForm);

        return "sample";
    }
}
