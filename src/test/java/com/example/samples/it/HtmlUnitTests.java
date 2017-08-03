package com.example.samples.it;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.example.samples.domain.Shouhin;
import com.example.samples.service.ShouhinService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HtmlUnitTests {

    @Autowired
    WebApplicationContext context;

    @MockBean
    ShouhinService shouhinService;

    WebClient webClient;

    @Before
    public void setup() {
        // no auth
        webClient = MockMvcWebClientBuilder
            .webAppContextSetup(context)
            .build();
    }

    @Test
    public void testMoveScreenSample() throws Exception {

        // initial page test
        HtmlPage page = webClient.getPage("http://localhost/sample");
        HtmlTextInput  elementShouhinId = page.getHtmlElementById("shouhinId");
        HtmlTextInput  elementShouhinName = page.getHtmlElementById("shouhinName");
        assertThat(elementShouhinId.getText()).isEqualTo(""); // initial empty
        assertThat(elementShouhinName.getText()).isEqualTo(""); // initial empty

        // update submit
        elementShouhinId.setText("itemid"); // update text
        elementShouhinName.setText("itemname"); // update text
        DomElement elementBtn = page.getElementById("btn");
        page = elementBtn.click();

        // after post page test
        elementShouhinName = page.getHtmlElementById("shouhinName");
        assertThat(elementShouhinName.getText()).isEqualTo("itemname"); // check disp value

        Shouhin shouhin = this.shouhinService.findByShouhinIdAndShouhinVer("itemid", new BigDecimal(1729));
        assertThat(shouhin.getShouhin(), is("itemname")); // check find data
    }

}
