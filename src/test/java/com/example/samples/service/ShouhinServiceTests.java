package com.example.samples.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.samples.domain.Shouhin;
import com.example.samples.domain.ShouhinRepository;
import com.example.samples.service.ShouhinService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShouhinServiceTests {

    @MockBean
    ShouhinRepository shouhinRepository;

    @Autowired
    ShouhinService shouhinService;

    @Test
    public void testFindByShouhinIdAndShouhinVer() throws Exception {

        Shouhin mockSouhin = new Shouhin();
        mockSouhin.setShouhinId("test1");
        mockSouhin.setShouhin("test2");

        given(this.shouhinRepository.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(mockSouhin);

        Shouhin shouhin = shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729));
        assertEquals(mockSouhin.toString(), shouhin.toString());
    }
}
