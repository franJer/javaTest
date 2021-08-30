package com.example.application.dto;


import com.example.application.model.entity.Price;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinalPriceDTO {

    public FinalPriceDTO() {
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



    public static FinalPriceDTO toDTO(Price price) {
        FinalPriceDTO finalPriceDTO = new FinalPriceDTO();
        finalPriceDTO.productId = String.valueOf(price.getProductId());
        finalPriceDTO.brandId = String.valueOf(price.getBrandId());
        finalPriceDTO.price = String.valueOf(price.getPrice());

        finalPriceDTO.startDate = price.getStartDate().format(formatter);
        finalPriceDTO.endDate = price.getEndDate().format(formatter);

        return finalPriceDTO;
    }

}
