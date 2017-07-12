package com.example.app.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamplebootAPI {

    private static Logger logger = LoggerFactory.getLogger(SamplebootAPI.class);

    @RequestMapping(value = "/")
    String top() {
        return "top";
    }

    @RequestMapping(value = "/hello")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/*")
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
