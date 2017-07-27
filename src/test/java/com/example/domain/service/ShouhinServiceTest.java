package com.example.domain.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.model.Shouhin;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class ShouhinServiceTest {

    //@Autowired
    //ShouhinService shouhinService;

    @Test
    public void testFindByShouhinIdAndShouhinVer() throws Exception {
        //Shouhin shouhin = new Shouhin();
        //shouhin.setShouhinId("1234");

        //Shouhin s = this.shouhinService.findByShouhinIdAndShouhinVer("1234", new BigDecimal(1729));
        //assertEquals(shouhin.getShouhinId(), s.getShouhinId());
    }
}
