package com.example.service;

import com.example.entity.PricesEntity;

import java.util.Date;

public interface PricesService {
    /**
     * The purpose of this function is to return the price for a specific product, group
     * and date, in case it founds two prices will return the one with higher priority
     * @param productId product id
     * @param groupId group id
     * @param date target date
     * @return PricesEntity
     */
    PricesEntity getPricesByProductDateGroup(String productId, String groupId, Date date);
}
