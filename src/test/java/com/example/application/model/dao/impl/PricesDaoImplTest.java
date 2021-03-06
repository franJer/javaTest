package com.example.application.model.dao.impl;

import com.example.application.model.dao.PricesDao;
import com.example.application.model.entity.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class PricesDaoImplTest {
    @Autowired
    private PricesDao pricesRepository;


    @Test
    @DisplayName("Test find by product, brand and date returning two elements")
    void findByProductBrandDateTestWithTwo() {

        LocalDateTime startDate = LocalDateTime.of(2021, Month.JULY, 29, 9, 30, 40);
        LocalDateTime endDate = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 40);
        LocalDateTime secondEndDate = LocalDateTime.of(2021, Month.JULY, 29, 17, 30, 40);
        LocalDateTime searchDate = LocalDateTime.of(2021, Month.JULY, 29, 11, 30, 40);

        int brandId = 1;
        int productId = 1;


        Price price = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(endDate).withPrioritiy(1).withId(1).build();

        Price created = pricesRepository.save(price);
        assertNotNull(created);

        Price price2 = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(secondEndDate).withPrioritiy(2).withId(2).build();

        created = pricesRepository.save(price2);
        assertNotNull(created);

        List<Price> priceListFiltered =
                pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, searchDate);

        assertEquals(priceListFiltered.size(), 2);
        assertEquals(priceListFiltered.get(0).getPriority(),2);

    }


    @Test
    @DisplayName("Test find by product, brand and date ")
    void findByProductBrandDateTest() {

        LocalDateTime startDate = LocalDateTime.of(2021, Month.JULY, 29, 9, 30, 40);
        LocalDateTime endDate = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 40);
        LocalDateTime searchDate = LocalDateTime.of(2021, Month.JULY, 29, 11, 30, 40);

        int brandId = 1;
        int brandId2 = 2;
        int productId = 1;


        Price price = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(endDate).withId(1).build();

        Price created1 = pricesRepository.save(price);
        assertNotNull(created1);

        Price price2 = new Price.Builder().withBrandId(brandId2).withProductId(productId).withStartDate(startDate).withEndDate(endDate).withId(2).build();

        Price created = pricesRepository.save(price2);
        assertNotNull(created);

        List<Price> priceListFiltered =
                pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, searchDate);

        assertEquals(priceListFiltered.size(),1);

    }


}