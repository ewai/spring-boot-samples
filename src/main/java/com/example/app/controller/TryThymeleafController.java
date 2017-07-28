package com.example.app.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.service.ShouhinService;

@Controller
public class TryThymeleafController {

    @Autowired
    ShouhinService shouhinService;

    @RequestMapping("thymeleaf")
    String load(Model model) {

        model.addAttribute("shouhin", shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729)));
        model.addAttribute("shouhinlist", shouhinService.findByShouhinVerAndShouhinbunruiId(new BigDecimal(1729), new BigDecimal(867)));
        model.addAttribute("test", "123");

        Map<String, String> map = new HashMap<String, String>();
        map.put("map1", "value1");
        map.put("map2", "value2");
        map.put("map3", "value3");
        model.addAttribute("map", map);

        List<Map<String, String>> list = new LinkedList<Map<String, String>>();
        list.add(map);
        list.add(map);
        list.add(map);
        model.addAttribute("list", list);

        return "thymeleaf";
    }
}
