package com.example.application.controler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PricesServiceTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA) ")
    public void getTest1() throws Exception {
        String spectedResult = "{\"productId\":\"35455\",\"brandId\":\"1\",\"price\":\"35.50\",\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14-10.00.00"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA) ")
    public void getTest2() throws Exception {
        String spectedResult = "{\"productId\":\"35455\",\"brandId\":\"1\",\"price\":\"25.45\",\"startDate\":\"2020-06-14-15.00.00\",\"endDate\":\"2020-06-14-18.30.00\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-14-16.00.00"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA) ")
    public void getTest3() throws Exception {
        String spectedResult = "{\"productId\":\"35455\",\"brandId\":\"1\",\"price\":\"35.50\",\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-14-21.00.00"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA) ")
    public void getTest4() throws Exception {
        String spectedResult = "{\"productId\":\"35455\",\"brandId\":\"1\",\"price\":\"30.50\",\"startDate\":\"2020-06-15-00.00.00\",\"endDate\":\"2020-06-15-11.00.00\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-15-10.00.00"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) ")
    public void getTest5() throws Exception {
        String spectedResult = "{\"productId\":\"35455\",\"brandId\":\"1\",\"price\":\"38.95\",\"startDate\":\"2020-06-15-16.00.00\",\"endDate\":\"2020-12-31-23.59.59\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-16-21.00.00"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }

    @Test
    @DisplayName("Test 6: Price not found ")
    public void getTest6() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "2")
                .param("date", "2020-06-16-21.00.00"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    @DisplayName("Test 7: Incorrect format date ")
    public void getTest7() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/prices")
                .contentType(MediaType.APPLICATION_JSON)
                .param("productId", "35455")
                .param("brandId", "2")
                .param("date", "P-06-16-21.00.00"))
                .andExpect(status().isNotAcceptable())
                .andReturn();
    }

}
