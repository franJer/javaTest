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

    public Price() {
    }

    private Price(Builder builder){
        this.id = builder.id;
        this.brandId = builder.brandId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.productId = builder.productId;
        this.priority = builder.priority;

    }
    public static class Builder {
        private int id;
        private int brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private int productId;
        private int priority;
        public Builder() {
        }
        public Builder withId(int id){
            this.id = id;
            return this;
        }

        public Builder withBrandId(int brandId){
            this.brandId = brandId;
            return this;
        }

        public Builder withStartDate(LocalDateTime startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDateTime endDate){
            this.endDate = endDate;
            return this;
        }


        public Builder withProductId(int productId){
            this.productId = productId;
            return this;
        }

        public Builder withPrioritiy(int priority){
            this.priority = priority;
            return this;
        }
        public Price build() {
            return new Price(this);
        }
    }



}
