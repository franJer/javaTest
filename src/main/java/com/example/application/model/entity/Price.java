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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceLis;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceLis() {
        return priceLis;
    }

    public void setPriceLis(int priceLis) {
        this.priceLis = priceLis;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPriotiy() {
        return priotiy;
    }

    public void setPriotiy(int priotiy) {
        this.priotiy = priotiy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
