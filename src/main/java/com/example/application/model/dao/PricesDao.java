package com.example.application.model.dao;

import com.example.application.model.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public interface PricesDao extends CrudRepository<Price, Long> {
    /**
     * The purpose of this function will be to access to the database and return the result
     * based on the parameters
     * @param productId product id
     * @param groupId group id
     * @param date target date
     * @return PricesEntity
     */
    Optional<Price> getPricesByProductDateGroup(String productId, String groupId, Date date);
}
