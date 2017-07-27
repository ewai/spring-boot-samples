package com.example.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.domain.model.Shouhin;
import com.example.domain.service.ShouhinService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ShouhinService shouhinService;

    @Test
    public void testOK() throws Exception {
        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("1234");

        when(this.shouhinService.findByShouhinIdAndShouhinVer("1234", new BigDecimal(1729))).thenReturn(shouhin);
        mvc.perform(get("sample")).andExpect(status().isOk()).andExpect(content().string(containsString("sample")));
    }
}
