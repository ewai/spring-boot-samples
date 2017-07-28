package com.example.app.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testログイン画面へ() throws Exception {
        mvc.perform(get("/sample")).andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username="0001", password="password8")
    public void test初期表示() throws Exception {
        mvc.perform(get("/sample")).andExpect(status().isOk()).andExpect(content().string(containsString("sample")));
    }
}
