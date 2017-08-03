package com.example.samples.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;
import com.example.samples.web.form.SampleForm;

@Controller
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    SampleValidator sampleValidator;

    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(sampleValidator);
    }

    @Autowired
    ShouhinService shouhinService;

    @Autowired
    HttpSession session;

    @RequestMapping(value="/sample", method=RequestMethod.GET)
//    String get(@ModelAttribute SampleForm shouhinForm, Model model) {
    String get(@ModelAttribute SampleForm sampleForm, Model model) {
        logger.info("get");
        Shouhin shouhin = this.shouhinService.findByShouhinIdAndShouhinVer(sampleForm.getShouhinId(), new BigDecimal(1729));
        if (shouhin != null) {
            sampleForm.setShouhinId(shouhin.getShouhinId());
            sampleForm.setShouhinName(shouhin.getShouhin());
        }
        //model.addAttribute("sampleForm", shouhinForm);
        model.addAttribute("sampleForm", new SampleForm());

        session.setAttribute("TEST_SESSION", "VALUE");
        return "sample";
    }

    @RequestMapping(value="/sample", method=RequestMethod.POST)
    String post(@ModelAttribute SampleForm sampleForm, BindingResult result, Model model) {
        logger.info("post");

        if (result.hasErrors()) {
            logger.info("has errors");
            return "redirect:sample";
        }

        Shouhin shouhin = this.shouhinService.findByShouhinIdAndShouhinVer(sampleForm.getShouhinId(), new BigDecimal(1729));
        if (shouhin != null) {
            logger.info("update");
            shouhin.setShouhin(sampleForm.getShouhinName());
        } else {
            logger.info("insert");
            shouhin = new Shouhin();
            shouhin.setShouhinId(sampleForm.getShouhinId());
            shouhin.setShouhin(sampleForm.getShouhinName());
            shouhin.setShouhinVer(new BigDecimal(1729));
        }
        this.shouhinService.save(shouhin);
        model.addAttribute("sampleForm", sampleForm);

        logger.info("session=" + session.getAttribute("TEST_SESSION"));
        return "sample";
    }
}
