package com.example.dao;

import com.example.entity.PricesEntity;

import java.util.Date;

public interface PricesDao {
    /**
     * The purpose of this function will be to access to the database and return the result
     * based on the parameters
     * @param productId product id
     * @param groupId group id
     * @param date target date
     * @return PricesEntity
     */
    PricesEntity getPricesByProductDateGroup(String productId, String groupId, Date date);
}
