package com.example.application.model.dao.impl;

import com.example.application.model.dao.PricesDao;
import com.example.application.model.entity.Price;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public abstract class PricesDaoImpl implements PricesDao {
    @Override
    public Optional<Price> getPricesByProductDateGroup(String productId, String groupId, Date date) {
        Price price  = new Price();
        Optional<Price> opt = Optional.ofNullable(price);
        return opt;
    }
}
