package com.example.application.dto;

public class FinalPriceDTO {
    public FinalPriceDTO(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    private String productId;

}
