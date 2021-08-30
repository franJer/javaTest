package com.example.application.service;

import com.example.application.model.entity.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public interface PricesService {
    /**
     * The purpose of this function is to return the prices for a specific product, group
     * and date, in case it founds two prices will return the one with higher priority
     * @param productId product id
     * @param groupId group id
     * @param date target date
     * @return PricesEntity
     */
    Optional<Price> getPricesByProductDateGroup(int productId, int groupId, LocalDateTime date);


}
