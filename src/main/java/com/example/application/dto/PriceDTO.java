package com.example.application.dto;


import com.example.application.model.entity.Price;

import java.time.format.DateTimeFormatter;

public class PriceDTO {

    public PriceDTO() {
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");


    private String productId;
    private String brandId;
    private String price;
    private String startDate;
    private String endDate;

    public String getProductId() {
        return productId;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }



    public static PriceDTO toDTO(Price price) {
        PriceDTO finalPriceDTO = new PriceDTO();
        finalPriceDTO.productId = String.valueOf(price.getProductId());
        finalPriceDTO.brandId = String.valueOf(price.getBrandId());
        finalPriceDTO.price = String.valueOf(price.getPrice());

        finalPriceDTO.startDate = price.getStartDate().format(formatter);
        finalPriceDTO.endDate = price.getEndDate().format(formatter);

        return finalPriceDTO;
    }

}
