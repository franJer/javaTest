package com.example.application.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="PRICES")
public class Price {
    @Id
    @GeneratedValue
    Long id;
    private String brandId;

    public String getBrandId() {
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

    public int getPriotiy() {
        return priotiy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priotiy;
    private BigDecimal price;
    private String currency;

    public Price(){

    }
    public Price(Long id, String brand) {
        this.id = id;
        this.brandId = brand;
    }
    public Price withBrandId(String brandId){
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

    public Price withPriceList(int priceList){
        this.priceList = priceList;
        return this;
    }

    public Price withProductId(int productId){
        this.productId = productId;
        return this;
    }

    public Price withPriotiy(int priotiy){
        this.priotiy = priotiy;
        return this;
    }

    public Price withPrice(BigDecimal price){
        this.price = price;
        return this;
    }

    public Price withCurrency(String currency){
        this.currency = currency;
        return this;
    }
}
