package com.example.dto;

public class FinalPriceDTO {
    public FinalPriceDTO(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    private String productId;

}
