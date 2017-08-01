package com.example.samples.web;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShouhinService shouhinService;

    @Before
    public void setup() {
        // no auth
        this.mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void testInitialFindData() throws Exception {

        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("test1");
        shouhin.setShouhin("test2");

        given(this.shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(shouhin);

        mvc.perform(get("/sample"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("test1")))
            .andExpect(content().string(containsString("test2")));
    }

    @Test
    public void testInitialNotFoundData() throws Exception {
        given(this.shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(null);

        mvc.perform(get("/sample")).andExpect(status().isOk()).andExpect(content().string(containsString("shouhinId")));
    }
}
