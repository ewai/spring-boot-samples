package com.example.samples.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.samples.domain.Sample;
import com.example.samples.domain.SampleRepository;
import com.example.samples.domain.ShouhinDaoImpl;

@RestController
public class RestSamplebootController {

    private static Logger logger = LoggerFactory.getLogger(RestSamplebootController.class);

    @Autowired
    HttpSession session;

    @Autowired
    SampleRepository sampleService;

    @PersistenceContext
    EntityManager entityManager;

    ShouhinDaoImpl shouhinDao;

    @RequestMapping(value = "/")
    String top() {
        logger.info("session=" + session.getAttribute("TEST_SESSION"));
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

    @RequestMapping(value = "/hello3")
    Object hello3() {

        this.shouhinDao = new ShouhinDaoImpl(this.entityManager);

        return this.shouhinDao.getShouhinList(new BigDecimal(1729));
    }

    @RequestMapping(value = "/hello4")
    Object hello4() {

        this.shouhinDao = new ShouhinDaoImpl(this.entityManager);

        return this.shouhinDao.getDistinctShouhinbunruiList(new BigDecimal(1729));
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

    @Autowired
    private MailSender sender;

    @RequestMapping(value = "/sendmail")
    void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("xxx@xxx.co.jp");
        msg.setTo("xxx@xxx.co.jp");
        msg.setSubject("テストメール");
        msg.setText("Spring Boot より本文送信");

        this.sender.send(msg);
    }

}