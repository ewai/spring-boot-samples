package com.example.app.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.model.Sample;
import com.example.domain.repository.SampleRepository;

@RestController
public class SamplebootAPI {

    private static Logger logger = LoggerFactory.getLogger(SamplebootAPI.class);

    @Autowired
    SampleRepository sampleService;

    @RequestMapping(value = "/")
    String top() {
        return "top";
    }

    @RequestMapping(value = "/hello")
    Object hello() {

        List<Sample> samples = sampleService.findAll();
        for (Sample sample : samples) {
            System.out.println(sample.getTestId());
        }

        return samples;
    }

    @RequestMapping(value = "/param/*")
    Object hello2() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "111");
        map.put("name", "test");
        list.add(map);
        list.add(map);
        list.add(map);
        logger.info("log test................");
        return list;
    }
}
