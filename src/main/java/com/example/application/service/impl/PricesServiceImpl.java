package com.example.application.service.impl;

import com.example.application.model.entity.Price;
import com.example.application.service.PricesService;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class PricesServiceImpl implements PricesService {
    @Override
    public Price getPricesByProductDateGroup(String productId, String groupId, Date date) {
        return null;
    }
}
