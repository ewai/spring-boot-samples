package com.example.samples.web;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;

@RestController
public class RestShouhinContoller {

    private static Logger logger = LoggerFactory.getLogger(RestShouhinContoller.class);

    @Autowired
    ShouhinService shouhinService;

    @RequestMapping(value = "/shouhin/shouhinId={shouhinId}")
    Object getShouhin(@PathVariable String shouhinId) {
        Shouhin shouhin = shouhinService.findByShouhinIdAndShouhinVer(shouhinId, new BigDecimal(1729));
        logger.info("getShouhin");
        return shouhin;
    }

    @RequestMapping(value = "/shouhin/shouhinbunruiId={shouhinbunruiId}")
    Object getShouhinList(@PathVariable BigDecimal shouhinbunruiId) {
        List<Shouhin> shouhinList = shouhinService.findByShouhinVerAndShouhinbunruiId(new BigDecimal(1729), shouhinbunruiId);
        logger.info("getShouhinList");
        return shouhinList;
    }

    @RequestMapping(value = "/shouhinbunruilist")
    Object getShouhinbunruilist() {
        logger.info("getShouhinbunruilist");
        return shouhinService.getShouhinbunruilist();
    }

}
