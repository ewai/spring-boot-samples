package com.example.samples.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;
import com.example.samples.web.form.SampleForm;

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
    public void testGet_InitiaPage() throws Exception {
        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("");
        shouhin.setShouhin("");

        MvcResult result =  mvc.perform(get("/sample").param("shouhinId", "").param("shouhinName", ""))
            .andExpect(status().isOk()).andReturn();

        ModelMap modelMap = result.getModelAndView().getModelMap();
        Object object = modelMap.get("sampleForm");
        assertThat(object, is(instanceOf(SampleForm.class)));

        SampleForm sampleForm = (SampleForm) object;
        assertThat(sampleForm.getShouhinId(), is(""));
        assertThat(sampleForm.getShouhinName(), is(""));
    }

    @Test
    public void testGet_findData() throws Exception {
        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("00014939");
        shouhin.setShouhin("item00014939");

        given(this.shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(shouhin);
        MvcResult result = mvc.perform(get("/sample").param("shouhinId", "00014939").param("shouhinName", ""))
            .andExpect(status().isOk()).andReturn();

        ModelMap modelMap = result.getModelAndView().getModelMap();
        Object object = modelMap.get("sampleForm");
        assertThat(object, is(instanceOf(SampleForm.class)));

        SampleForm sampleForm = (SampleForm) object;
        assertThat(sampleForm.getShouhinId(), is("00014939"));
        assertThat(sampleForm.getShouhinName(), is("item00014939"));
    }

    @Test
    public void testGet_NotFoundData() throws Exception {
        given(this.shouhinService.findByShouhinIdAndShouhinVer(null, new BigDecimal(1729))).willReturn(null);

        MvcResult result = mvc.perform(get("/sample").param("shouhinId", "").param("shouhinName", ""))
            .andExpect(status().isOk()).andReturn();

        ModelMap modelMap = result.getModelAndView().getModelMap();
        Object object = modelMap.get("sampleForm");
        assertThat(object, is(instanceOf(SampleForm.class)));

        SampleForm sampleForm = (SampleForm) object;
        assertThat(sampleForm.getShouhinId(), is(""));
        assertThat(sampleForm.getShouhinName(), is(""));
    }

    @Test
    public void testPost_findData() throws Exception {
        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("00014939");
        shouhin.setShouhin("input");

        Shouhin findShouhin = new Shouhin();
        findShouhin.setShouhinId("00014939");
        findShouhin.setShouhin("db");

        given(this.shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(findShouhin);
        given(this.shouhinService.save(shouhin)).willReturn(shouhin);

        MvcResult result = mvc.perform(post("/sample")
            .param("shouhinId", "00014939")
            .param("shouhinName", "input"))
            .andExpect(status().isOk()).andReturn();

        ModelMap modelMap = result.getModelAndView().getModelMap();
        Object object = modelMap.get("sampleForm");
        assertThat(object, is(instanceOf(SampleForm.class)));

        SampleForm sampleForm = (SampleForm) object;
        assertThat(sampleForm.getShouhinId(), is("00014939"));
        assertThat(sampleForm.getShouhinName(), is("input"));
    }

    @Test
    public void testPost_NotFoundData() throws Exception {
        Shouhin shouhin = new Shouhin();
        shouhin.setShouhinId("00014939");
        shouhin.setShouhin("input");

        given(this.shouhinService.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(1729))).willReturn(null);
        given(this.shouhinService.save(shouhin)).willReturn(shouhin);

        MvcResult result = mvc.perform(post("/sample").param("shouhinId", "00014939").param("shouhinName", "input"))
            .andExpect(status().isOk()).andReturn();

        ModelMap modelMap = result.getModelAndView().getModelMap();
        Object object = modelMap.get("sampleForm");
        assertThat(object, is(instanceOf(SampleForm.class)));

        SampleForm sampleForm = (SampleForm) object;
        assertThat(sampleForm.getShouhinId(), is("00014939"));
        assertThat(sampleForm.getShouhinName(), is("input"));
    }
}
