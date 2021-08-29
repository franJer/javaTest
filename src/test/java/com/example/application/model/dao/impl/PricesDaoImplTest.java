package com.example.application.model.dao.impl;

import com.example.application.model.dao.PricesDao;
import com.example.application.model.entity.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class PricesDaoImplTest {
    @Autowired
    private PricesDao pricesRepository;

    @Test
    @DisplayName("Create User Test ")
    void createUserTest() {

        Price created = pricesRepository.save(getPrice());

        assertNotNull(created);
    }

    private Price getPrice() {

        Price price = new Price();
        return price.withBrandId("ZARA");
    }
}