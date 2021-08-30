package com.example.application.service.impl;

import com.example.application.model.dao.PricesDao;
import com.example.application.model.entity.Price;
import com.example.application.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class PricesServiceImpl implements PricesService {
    @Autowired
    private PricesDao pricesRepository;
    @Override
    public Optional<Price> getPricesByProductDateGroup(int productId, int groupId, LocalDateTime date) {
        List<Price> priceListFiltered = pricesRepository.findByProductIdAndBrandIdAndDate(productId, groupId, date);
        return priceListFiltered.stream().findFirst();
    }
}
