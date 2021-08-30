package com.example.application.service.impl;

import com.example.application.model.dao.PricesDao;
import com.example.application.model.entity.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PricesServiceImplTest {

    @Mock
    PricesDao pricesDao;
    @InjectMocks
    private PricesServiceImpl pricesService;

    private int brandId = 1;
    private int productId = 1;
    private LocalDateTime searchDate = LocalDateTime.of(2021, Month.JULY, 29, 11, 30, 40);

    @Test
    @DisplayName("Test find by product, brand and date with two elements")
    void findByProductBrandDateTestWithTwo() {

        LocalDateTime startDate = LocalDateTime.of(2021, Month.JULY, 29, 9, 30, 40);
        LocalDateTime endDate = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 40);
        LocalDateTime secondEndDate = LocalDateTime.of(2021, Month.JULY, 29, 17, 30, 40);


        Price price = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(endDate).withPrioritiy(1).build();
        Price price2 = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(secondEndDate).withPrioritiy(2).build();
        List<Price> listOfPrices = new ArrayList<>();
        listOfPrices.add(price);
        listOfPrices.add(price2);

        Mockito.when(pricesDao.findByProductIdAndBrandIdAndDate(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenReturn(listOfPrices);
        Optional<Price> priceFiltered = pricesService.getPricesByProductDateGroup(productId, brandId, searchDate);

        assertTrue(priceFiltered.isPresent());
        assertEquals(priceFiltered.get().getBrandId(),brandId);
    }

    @Test
    @DisplayName("Test find by product, brand and date with no elements")
    void findByProductBrandDateTestWithNoElement() {
        List<Price> listOfPrices = new ArrayList<>();
        Mockito.when(pricesDao.findByProductIdAndBrandIdAndDate(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenReturn(listOfPrices);
        Optional<Price> priceFiltered = pricesService.getPricesByProductDateGroup(productId, brandId, searchDate);
        assertFalse(priceFiltered.isPresent());
    }

    @Test
    @DisplayName("Test find by product, brand and date with one elements")
    void findByProductBrandDateTestWithOneElement() {
        LocalDateTime startDate = LocalDateTime.of(2021, Month.JULY, 29, 9, 30, 40);
        LocalDateTime endDate = LocalDateTime.of(2021, Month.JULY, 29, 19, 30, 40);
        Price price = new Price.Builder().withBrandId(brandId).withProductId(productId).withStartDate(startDate).withEndDate(endDate).withPrioritiy(1).build();
        List<Price> listOfPrices = new ArrayList<>();
        listOfPrices.add(price);
        Mockito.when(pricesDao.findByProductIdAndBrandIdAndDate(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenReturn(listOfPrices);
        Optional<Price> priceFiltered = pricesService.getPricesByProductDateGroup(productId, brandId, searchDate);

        assertTrue(priceFiltered.isPresent());
        assertEquals(priceFiltered.get().getBrandId(),brandId);

    }

}