package com.example.sampleboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Sampleboot2Application {

    private static Logger logger = LoggerFactory.getLogger(Sampleboot2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Sampleboot2Application.class, args);
	}

    @RequestMapping(value = "/")
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
