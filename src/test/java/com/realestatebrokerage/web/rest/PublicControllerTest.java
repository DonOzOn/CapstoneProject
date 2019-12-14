package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.RealestatebrokerageApp;
import com.realestatebrokerage.domain.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RealestatebrokerageApp.class)
@WebAppConfiguration
class PublicControllerTest {

    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getProvince() throws Exception  {
        String uri = "/provinces";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        int content = mvcResult.getResponse().getContentLength();
        Assertions.assertEquals(63, content);
//        restMockMvc.perform(get("/provinces").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void getDistrict()throws Exception  {
        mvc.perform(get("/districts")).andExpect(status().isOk());
    }

    @Test
    void getWard() throws Exception {
        mvc.perform(get("/wards")).andExpect(status().isOk());
    }
    @Test
    void getReviewNews() {
    }

    @Test
    void getAllReviewByUserID() {
    }

    @Test
    void getReviewByID() {
    }

    @Test
    void getAllNewByDate() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateNews() {
    }

    @Test
    void deleteNews() {
    }

    @Test
    void fullTextSearchReview() {
    }
}
