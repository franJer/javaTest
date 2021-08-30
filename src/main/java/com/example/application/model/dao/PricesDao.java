package com.example.application.model.dao;

import com.example.application.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PricesDao extends JpaRepository<Price, Long>   {
    /**
     * This function will return the list of prices that mateches the parameters order by the priority
     * @param productId product id
     * @param brandId brand id
     * @param targetDate taget date to get the price
     * @return list of prices
     */
    @Query("select p from Price p where :targetDate between p.startDate and p.endDate and p.productId =:productId and p.brandId=:brandId order by p.priority desc")
    List<Price> findByProductIdAndBrandIdAndDate(int productId, int brandId, LocalDateTime targetDate);


}

