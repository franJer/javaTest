package com.example.application.model.dao;

import com.example.application.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PricesDao extends JpaRepository<Price, Long>   {
    @Query("select p from Price p where p.startDate <=:startDate and p.endDate >=: startDate and p.productId =:productId and p.brandId=:brandId order by p.priotiy desc")
    List<Price> findByProductIdAndBrandIdAndDate(int productId, String brandId, LocalDateTime startDate);
}

