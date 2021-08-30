package com.example.application.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="PRICES")
public class Price {
    @Id
    private int id;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private BigDecimal price;
    private String currency;

    public int getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public int getProductId() {
        return productId;
    }

    public int getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }



    public Price(){

    }

    public Price withId(int id){
        this.id = id;
        return this;
    }

    public Price withBrandId(int brandId){
        this.brandId = brandId;
        return this;
    }

    public Price withStartDate(LocalDateTime startDate){
        this.startDate = startDate;
        return this;
    }

    public Price withEndDate(LocalDateTime endDate){
        this.endDate = endDate;
        return this;
    }


    public Price withProductId(int productId){
        this.productId = productId;
        return this;
    }

    public Price withPrioritiy(int priority){
        this.priority = priority;
        return this;
    }

}
